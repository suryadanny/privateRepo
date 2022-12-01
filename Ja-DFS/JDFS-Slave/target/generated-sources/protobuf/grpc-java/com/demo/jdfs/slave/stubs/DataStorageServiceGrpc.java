package com.demo.jdfs.slave.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: slave.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataStorageServiceGrpc {

  private DataStorageServiceGrpc() {}

  public static final String SERVICE_NAME = "com.demo.jdfs.slave.DataStorageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.ViewFileRequest,
      com.demo.jdfs.slave.stubs.ViewFileResponse> getGetFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFile",
      requestType = com.demo.jdfs.slave.stubs.ViewFileRequest.class,
      responseType = com.demo.jdfs.slave.stubs.ViewFileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.ViewFileRequest,
      com.demo.jdfs.slave.stubs.ViewFileResponse> getGetFileMethod() {
    io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.ViewFileRequest, com.demo.jdfs.slave.stubs.ViewFileResponse> getGetFileMethod;
    if ((getGetFileMethod = DataStorageServiceGrpc.getGetFileMethod) == null) {
      synchronized (DataStorageServiceGrpc.class) {
        if ((getGetFileMethod = DataStorageServiceGrpc.getGetFileMethod) == null) {
          DataStorageServiceGrpc.getGetFileMethod = getGetFileMethod =
              io.grpc.MethodDescriptor.<com.demo.jdfs.slave.stubs.ViewFileRequest, com.demo.jdfs.slave.stubs.ViewFileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.slave.stubs.ViewFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.slave.stubs.ViewFileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataStorageServiceMethodDescriptorSupplier("getFile"))
              .build();
        }
      }
    }
    return getGetFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.FileStorageRequest,
      com.demo.jdfs.slave.stubs.FileStorageResponse> getPutFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putFile",
      requestType = com.demo.jdfs.slave.stubs.FileStorageRequest.class,
      responseType = com.demo.jdfs.slave.stubs.FileStorageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.FileStorageRequest,
      com.demo.jdfs.slave.stubs.FileStorageResponse> getPutFileMethod() {
    io.grpc.MethodDescriptor<com.demo.jdfs.slave.stubs.FileStorageRequest, com.demo.jdfs.slave.stubs.FileStorageResponse> getPutFileMethod;
    if ((getPutFileMethod = DataStorageServiceGrpc.getPutFileMethod) == null) {
      synchronized (DataStorageServiceGrpc.class) {
        if ((getPutFileMethod = DataStorageServiceGrpc.getPutFileMethod) == null) {
          DataStorageServiceGrpc.getPutFileMethod = getPutFileMethod =
              io.grpc.MethodDescriptor.<com.demo.jdfs.slave.stubs.FileStorageRequest, com.demo.jdfs.slave.stubs.FileStorageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putFile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.slave.stubs.FileStorageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.slave.stubs.FileStorageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataStorageServiceMethodDescriptorSupplier("putFile"))
              .build();
        }
      }
    }
    return getPutFileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataStorageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceStub>() {
        @java.lang.Override
        public DataStorageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStorageServiceStub(channel, callOptions);
        }
      };
    return DataStorageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataStorageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceBlockingStub>() {
        @java.lang.Override
        public DataStorageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStorageServiceBlockingStub(channel, callOptions);
        }
      };
    return DataStorageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataStorageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataStorageServiceFutureStub>() {
        @java.lang.Override
        public DataStorageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataStorageServiceFutureStub(channel, callOptions);
        }
      };
    return DataStorageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataStorageServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFile(com.demo.jdfs.slave.stubs.ViewFileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.ViewFileResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFileMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.FileStorageRequest> putFile(
        io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.FileStorageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getPutFileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFileMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.demo.jdfs.slave.stubs.ViewFileRequest,
                com.demo.jdfs.slave.stubs.ViewFileResponse>(
                  this, METHODID_GET_FILE)))
          .addMethod(
            getPutFileMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                com.demo.jdfs.slave.stubs.FileStorageRequest,
                com.demo.jdfs.slave.stubs.FileStorageResponse>(
                  this, METHODID_PUT_FILE)))
          .build();
    }
  }

  /**
   */
  public static final class DataStorageServiceStub extends io.grpc.stub.AbstractAsyncStub<DataStorageServiceStub> {
    private DataStorageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStorageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStorageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFile(com.demo.jdfs.slave.stubs.ViewFileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.ViewFileResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.FileStorageRequest> putFile(
        io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.FileStorageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getPutFileMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class DataStorageServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataStorageServiceBlockingStub> {
    private DataStorageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStorageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStorageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.demo.jdfs.slave.stubs.ViewFileResponse> getFile(
        com.demo.jdfs.slave.stubs.ViewFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetFileMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataStorageServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataStorageServiceFutureStub> {
    private DataStorageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataStorageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataStorageServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_FILE = 0;
  private static final int METHODID_PUT_FILE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataStorageServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataStorageServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FILE:
          serviceImpl.getFile((com.demo.jdfs.slave.stubs.ViewFileRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.ViewFileResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT_FILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.putFile(
              (io.grpc.stub.StreamObserver<com.demo.jdfs.slave.stubs.FileStorageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataStorageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.jdfs.slave.stubs.SlaveOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataStorageService");
    }
  }

  private static final class DataStorageServiceFileDescriptorSupplier
      extends DataStorageServiceBaseDescriptorSupplier {
    DataStorageServiceFileDescriptorSupplier() {}
  }

  private static final class DataStorageServiceMethodDescriptorSupplier
      extends DataStorageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataStorageServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataStorageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataStorageServiceFileDescriptorSupplier())
              .addMethod(getGetFileMethod())
              .addMethod(getPutFileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
