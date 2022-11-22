package com.demo.jdfs.slave.server;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.jdfs.slave.service.impl.DataManagerServiceImpl;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SlaveStorageServer {
	private Server hostServer;
	
	final static Logger log = LoggerFactory.getLogger(SlaveStorageServer.class);

	
	public void start(int port) {
	    try {
	    	
	    	log.info("Starting Indexing service!!");
	    	hostServer = ServerBuilder.forPort(port).addService((BindableService) new DataManagerServiceImpl()).build().start();
	    	log.info("Service started at : "+ hostServer.getPort());
	    	Runtime.getRuntime().addShutdownHook(new Thread() {
	    		@Override
	    		public void run() {
	    			try {
	    				log.info("stopping server!!");
	    				SlaveStorageServer.this.stopServer();
					} catch (InterruptedException ex) {
						log.error("error occurred stopping server!!",ex);
						
					}
	    		}
	    	});
	    }catch(Exception ex) {
	    	log.error("Error occurred while instantiating or starting the server!! : ",ex);
	    	
	    }
	}
	
	public void stopServer() throws InterruptedException {
		if(hostServer!= null) {
			log.info("Stopping Server");
			hostServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
		}
			
	}
	
	public void blockUntilShutdown() throws InterruptedException {
		
		if(hostServer!= null) {
			log.info("Indexing service is live and available");
			hostServer.awaitTermination();
			
		}
			
	}
	
	public static void main(String[] args) throws InterruptedException {
		log.info("Server will be starting on port  : "+args[0]);
		if(args == null || args[0] == null || args[0].isEmpty() )
		{
			log.info("please specify port : stopping server initialization of Master Node!!");
		}
		
		SlaveStorageServer storageServer = new SlaveStorageServer();
		storageServer.start(Integer.parseInt(args[0]));
		
		storageServer.blockUntilShutdown();
	}
}
