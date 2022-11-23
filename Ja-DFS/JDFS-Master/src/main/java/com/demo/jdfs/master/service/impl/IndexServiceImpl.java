package com.demo.jdfs.master.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.jdfs.master.server.MasterIndexServer;
import com.demo.jdfs.master.stubs.Block;
import com.demo.jdfs.master.stubs.CreateOrEditFileRequest;
import com.demo.jdfs.master.stubs.FileIndexResponse;
import com.demo.jdfs.master.stubs.FileRequest;
import com.demo.jdfs.master.stubs.IndexServiceGrpc;
import com.demo.jdfs.master.stubs.Slave;

import io.grpc.stub.StreamObserver;

public class IndexServiceImpl extends  IndexServiceGrpc.IndexServiceImplBase {
 
	 private Map<String,List<String>> fileAllocList;
	 private Map<String,String> slaveServerMapping;
	 private Map<String,List<String>> blockAllocMemory;
	 private int blockSize = 100;
	 private int repetitionFactor = 2;
	 
	 final static Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);
	  public IndexServiceImpl() {
		  super();
		  
		  fileAllocList = new HashMap<String,List<String>>();
		  slaveServerMapping = new  HashMap<String,String>();
		  blockAllocMemory = new HashMap<String,List<String>>();
		  slaveServerMapping.put("A", "127.0.0.1:50056");
		  slaveServerMapping.put("B", "127.0.0.1:50056");
		  slaveServerMapping.put("C", "127.0.0.1:50056");
		  slaveServerMapping.put("D", "127.0.0.1:50056");
	  }
	
      public void getFileDetails(FileRequest fileRequest,StreamObserver<FileIndexResponse> observer ) {
    	  String fileName = fileRequest.getFileName();
    	  List<Block> blockList = new ArrayList<Block>();
    	  log.info("here to get file : "+ fileName);
    	  if(fileAllocList.containsKey(fileName)) {
    		  fileAllocList.get(fileName).stream().forEach(b -> {
    			  
    			  List<Slave> slaveList = new ArrayList<Slave>();
    			  blockAllocMemory.get(b).forEach(slave  -> {
    				 Slave sl =  Slave.newBuilder().setUrl(slaveServerMapping.get(slave)).setSlaveId(slave).build();
    				 slaveList.add(sl);
    			  });
    			  Block block = Block.newBuilder().setBlockId(b).addAllSlaves(slaveList).build();
    			  blockList.add(block);
    		  });
    	  }
    	  FileIndexResponse response = FileIndexResponse.newBuilder().setFilename(fileName).addAllBlocks(blockList).build();
    	  log.info("Blocks found for the file :"+response.getBlocksCount());
    	  observer.onNext(response);
    	  observer.onCompleted();
      }
      
      
      public void  putFilesDetails(CreateOrEditFileRequest request,
    	        StreamObserver<FileIndexResponse> responseObserver) {
    	  String fileName =  request.getFileName();
    	  long size = request.getFileSize();
    	  long numBlocks = (size/blockSize) + ((size%blockSize > 0)? 1l : 0l);
    	  
    	  List<Block> blockList = new ArrayList<Block>();
    	  List<String> slaveList = new ArrayList<String>(slaveServerMapping.keySet());
    	  for(int i = 0 ; i< numBlocks ;i++ ) {
    		  List<String> selectSlaveServers =  getRandom(slaveList,repetitionFactor);
    		  String uuid = UUID.randomUUID().toString();
    		  List<Slave> slaves = new ArrayList<Slave>();
    		 
    		  selectSlaveServers.forEach(slave -> {
    			  slaves.add(Slave.newBuilder().setSlaveId(slave).setUrl(slaveServerMapping.get(slave)).build());
    		  });
    		  Block block = Block.newBuilder().setBlockId(uuid).addAllSlaves(slaves).build();
    		  blockList.add(block);
    		  blockAllocMemory.put(uuid,selectSlaveServers);
    		  if(!fileAllocList.containsKey(fileName)) {
    			  fileAllocList.put(fileName, new ArrayList<String>());
    		  }
    		  
    		  fileAllocList.get(fileName).add(uuid);
    	  }
    	  FileIndexResponse response  = FileIndexResponse.newBuilder().setFilename(fileName).addAllBlocks(blockList).build();
    	  responseObserver.onNext(response);
    	  responseObserver.onCompleted();
    	  
      }
      
      public List<String> getRandom(List<String> list, int numElements){
    	  Random random = new Random();
    	  List<String> randomList = new ArrayList<String>();
    	  
    	  for(int i = 0 ; i< numElements ;i++) {
    		  int ranInt = random.nextInt(list.size());
    		  randomList.add(list.get(ranInt));
    	  }
    	  return randomList;
      }
}
