package com.demo.jdfs.master.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.jdfs.master.stubs.FileIndexResponse;
import com.demo.jdfs.master.stubs.FileRequest;
import com.demo.jdfs.master.stubs.IndexServiceGrpc;

import io.grpc.stub.StreamObserver;

public class IndexServiceImpl extends  IndexServiceGrpc.IndexServiceImplBase {
 
	 private Map<String,List<String>> fileAllocList;
	 private Map<String,String> slaveServerMapping;
	 private Map<String,List<String>> blockAllocMemory;
	 
	  
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
    	  if(fileAllocList.containsKey(fileName)) {
    		  fileAllocList.get(fileName).stream().map(s -> {return  blockAllocMemory.get(s);}).
    	  }
    	  
      }
}
