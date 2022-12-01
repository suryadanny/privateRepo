package com.demo.jdfs.slave.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.jdfs.slave.stubs.DataStorageServiceGrpc;
import com.demo.jdfs.slave.stubs.DataStorageServiceGrpc.DataStorageServiceBlockingStub;
import com.demo.jdfs.slave.stubs.DataStorageServiceGrpc.DataStorageServiceStub;
import com.demo.jdfs.slave.stubs.FileStorageRequest;
import com.demo.jdfs.slave.stubs.FileStorageResponse;
import com.demo.jdfs.slave.stubs.Slave;
import com.demo.jdfs.slave.stubs.ViewFileRequest;
import com.demo.jdfs.slave.stubs.ViewFileResponse;
import com.google.protobuf.ByteString;
import com.google.rpc.Status;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;

public class DataManagerServiceImpl extends DataStorageServiceGrpc.DataStorageServiceImplBase  {
	
	private String storageLocation = "D:\\project\\store\\A\\" ;
    private BufferedInputStream reader ;
    private AtomicBoolean slaveActive = new AtomicBoolean(false);
    private final Logger log = LoggerFactory.getLogger(DataManagerServiceImpl.class);
	
	
	public DataManagerServiceImpl(String path) {
		super();
		
		File dir;
		if(!(dir = new File(path)).exists()) {
			dir.mkdirs();
		}
		
		if(dir.exists()) {
			this.storageLocation = Paths.get(path,new String[0] ).toString().concat("\\");
			
			
		}
		
		log.info("Storage service referring to {} directory.", this.storageLocation);
	}
	
	@Override
	public void getFile(ViewFileRequest request,
	        StreamObserver<ViewFileResponse> responseObserver) {
		String filePath = storageLocation  + request.getPartitionName();
		byte[] data= new byte[8192];
		log.info("filePath : {}",filePath);
		
		if(Files.exists(Paths.get(filePath))) {
			
			try {
				reader = new BufferedInputStream(new FileInputStream(filePath));
				    int line;
					while(( line = reader.read(data)) != -1) {
						responseObserver.onNext(ViewFileResponse.newBuilder().setData(ByteString.copyFrom(data)).build());
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
		
	
		responseObserver.onCompleted();
		
		
	}
	
    @Override
	public StreamObserver<FileStorageRequest> putFile(
	        StreamObserver<FileStorageResponse> responseObserver) {
    	
    	
    	return new StreamObserver<FileStorageRequest>() {
            
    		BufferedOutputStream streamWriter;
    		String path= "";
    		StreamObserver<FileStorageRequest> clientResponseObserver;
    		
			@Override
			public void onNext(FileStorageRequest request) {
				String filePath = storageLocation + request.getPartitionName();
				log.info("partition {} being stored ",filePath );
				try {
					if(!filePath.equalsIgnoreCase(path)) {
						if(streamWriter != null)
							streamWriter.close();
						streamWriter = new BufferedOutputStream(new FileOutputStream(filePath,true));
					}
					
					streamWriter.write(request.getData().toByteArray());
					streamWriter.flush();
				}catch(Exception ex) {
					log.info("Error occurred while writing partition - " + request.getPartitionName() + " : " + ex.getMessage()  );
				}
				if(request.getSlavesList().size() > 0) {
				   Slave slave =   request.getSlavesList().get(0);
				   List<Slave> slaveList = new ArrayList<Slave>(request.getSlavesList());
				   slaveList.remove(0);
				   if(clientResponseObserver  == null)
					   clientResponseObserver =  putForward(request,slave);
				   
				  // clientResponseObserver.onNext(request);
				   clientResponseObserver.onNext(FileStorageRequest.newBuilder().setData(request.getData()).setPartitionName(request.getPartitionName()).addAllSlaves(slaveList).build());
				}
				
			}

			@Override
			public void onError(Throwable t) {
				 log.error("Error message while writing file : {}",t.getMessage(),t);
				
			}

			@Override
			public void onCompleted() {
				
				if(clientResponseObserver != null) {
					clientResponseObserver.onCompleted();
					clientResponseObserver = null;
				}
				try {
					streamWriter.close();
				} catch (IOException e) {
					log.info("Error occurred while closing writer - " );
				}
				FileStorageResponse response = FileStorageResponse.newBuilder().setSaved(true).build();
				
				while(slaveActive.get()) {
					
				}
				
				log.info("Response to be sent");
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				
			}
    		
    	};
    	

	
	}
	
	
	public StreamObserver<FileStorageRequest> putForward(FileStorageRequest request,Slave slave) {
		
		slaveActive.getAndSet(true);
		
		StreamObserver<FileStorageResponse> requestObserver = new StreamObserver<FileStorageResponse>() {

			@Override
			public void onNext(FileStorageResponse value) {
				log.info("File stored in slave :  {} ",value.getSaved());
				
			}

			@Override
			public void onError(Throwable t) {
			    log.error("Error ocurred while receving put file response from slave server : {}",t.getMessage(),t);
				
			}

			@Override
			public void onCompleted() {
				slaveActive.compareAndSet(true, false);
				log.info("finished streaming to slave from this server");
				
			}
			
		};
		String[] url  = slave.getUrl().split(":");
	   
		Channel channel = ManagedChannelBuilder.forAddress(url[0],Integer.parseInt(url[1].trim())).usePlaintext().build();
		DataStorageServiceStub  service = DataStorageServiceGrpc.newStub(channel);
		StreamObserver<FileStorageRequest> response = service.putFile(requestObserver);
		return response;
	}

	
    
	
}
