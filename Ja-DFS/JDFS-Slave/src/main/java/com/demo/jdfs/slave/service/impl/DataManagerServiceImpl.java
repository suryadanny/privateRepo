package com.demo.jdfs.slave.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.jdfs.slave.stubs.DataStorageServiceGrpc;
import com.demo.jdfs.slave.stubs.DataStorageServiceGrpc.DataStorageServiceBlockingStub;
import com.demo.jdfs.slave.stubs.FileStorageRequest;
import com.demo.jdfs.slave.stubs.FileStorageResponse;
import com.demo.jdfs.slave.stubs.Slave;
import com.demo.jdfs.slave.stubs.ViewFileRequest;
import com.demo.jdfs.slave.stubs.ViewFileResponse;
import com.google.rpc.Status;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;

public class DataManagerServiceImpl extends DataStorageServiceGrpc.DataStorageServiceImplBase  {
	
	String storageLocation ;
    BufferedReader reader ;
    BufferedWriter writer;
    final Logger log = LoggerFactory.getLogger(DataManagerServiceImpl.class);
	
	
	public DataManagerServiceImpl() {
		super();
		storageLocation ="D:\\project\\store\\A\\";
		
	}
	
	@Override
	public void getFile(ViewFileRequest request,
	        StreamObserver<ViewFileResponse> responseObserver) {
		String filePath = storageLocation + request.getPartitionName();
		String data= "";
		
		if(Files.exists(Paths.get(filePath))) {
			
			try {
				reader = new BufferedReader(new FileReader(filePath));
				String line;
			
					while(( line = reader.readLine()) != null) {
						data = data+line;
					}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.info("error occurred while reading file : "+ e.getMessage());
				Status status = Status.newBuilder().setMessage(e.getMessage()).build();
				responseObserver.onError(StatusProto.toStatusRuntimeException(status));
			}
		} else {
			Status status = Status.newBuilder().setMessage("No partition found with the specified name !!").build();
			responseObserver.onError(StatusProto.toStatusRuntimeException(status));
		}
		
		ViewFileResponse response = ViewFileResponse.newBuilder().setData(data).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
		
		
	}
	
	@Override
	public void putFile(FileStorageRequest request,
			StreamObserver<FileStorageResponse> responseObserver) {
		String filePath = storageLocation + request.getPartitionName();
		
		try {
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(request.getData());
		}catch(Exception ex) {
			log.info("Error occurred while writing partition - " + request.getPartitionName() + " : " + ex.getMessage()  );
		}
		if(request.getSlavesList().size() > 0) {
		   Slave slave =   request.getSlavesList().remove(0);
		   putForward(request,slave);
		}
		FileStorageResponse response = FileStorageResponse.newBuilder().setSaved(true).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	
	
	public void putForward(FileStorageRequest request,Slave slave) {
	    String[] url  = slave.getUrl().split(":");
		Channel channel = ManagedChannelBuilder.forAddress(url[0],Integer.parseInt(url[1].trim())).build();
		DataStorageServiceBlockingStub  service = DataStorageServiceGrpc.newBlockingStub(channel);
		service.putFile(request);
	}

	
    
	
}
