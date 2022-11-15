package com.demo.jdfs.master.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
	  
	  public IndexServiceImpl() {
		  super();
		  
		  fileAllocList = new HashMap<String,List<String>>();
		  slaveServerMapping = new  HashMap<String,String>();
		  blockAllocMemory = new HashMap<String,List<String>>();
		  slaveServerMapping.put("A", "localHost:52000");
		  slaveServerMapping.put("B", "localHost:52001");
		  slaveServerMapping.put("C", "localHost:52002");
	  }
	
      public void getFileDetails(FileRequest fileRequest,StreamObserver<FileIndexResponse> observer ) {
    	  String fileName = fileRequest.getFileName();
    	  FileIndexResponse response = FileIndexResponse.newBuilder().setFilename(fileName).build();
    	  if(fileAllocList.containsKey(fileName)) {
    		  fileAllocList.get(fileName).stream().forEach(s -> {
    			  Block block = Block.newBuilder().setBlockId(s).build();
    			  
    			  blockAllocMemory.get(s).forEach(slave  -> {
    				 Slave sl =  Slave.newBuilder().setUrl(slaveServerMapping.get(slave)).setSlaveId(slave).build();
    				 block.getSlavesList().add(sl);
    			  });
    			  response.getBlocksList().add(block);
    		  });
    	  }
    	  observer.onNext(response);
    	  observer.onCompleted();
      }
      
      
      public void  putFilesDetails(CreateOrEditFileRequest request,
    	        StreamObserver<FileIndexResponse> responseObserver) {
    	  String fileName =  request.getFileName();
    	  long size = request.getFileSize();
    	  long numBlocks = (size/blockSize) + ((size%blockSize > 0)? 1l : 0l);
    	  FileIndexResponse response  = FileIndexResponse.newBuilder().setFilename(fileName).build();
    	  List<String> slaveList = new ArrayList<String>(slaveServerMapping.keySet());
    	  for(int i = 0 ; i< numBlocks ;i++ ) {
    		  List<String> selectSlaveServers =  getRandom(slaveList,repetitionFactor);
    		  String uuid = UUID.randomUUID().toString();
    		  Block block = Block.newBuilder().setBlockId(uuid).build();
    		  selectSlaveServers.forEach(slave -> {
    			  block.getSlavesList().add(Slave.newBuilder().setSlaveId(slave).setUrl(slaveServerMapping.get(slave)).build());
    		  });
    		  response.getBlocksList().add(block);
    		  blockAllocMemory.put(uuid,selectSlaveServers);
    	  }
    	  
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
