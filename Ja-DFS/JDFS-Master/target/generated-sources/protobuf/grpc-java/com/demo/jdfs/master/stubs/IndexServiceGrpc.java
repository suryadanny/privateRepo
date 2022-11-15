package com.demo.jdfs.master.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: master.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IndexServiceGrpc {

  private IndexServiceGrpc() {}

  public static final String SERVICE_NAME = "com.demo.jdfs.master.IndexService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.FileRequest,
      com.demo.jdfs.master.stubs.FileIndexResponse> getGetFileDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFileDetails",
      requestType = com.demo.jdfs.master.stubs.FileRequest.class,
      responseType = com.demo.jdfs.master.stubs.FileIndexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.FileRequest,
      com.demo.jdfs.master.stubs.FileIndexResponse> getGetFileDetailsMethod() {
    io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.FileRequest, com.demo.jdfs.master.stubs.FileIndexResponse> getGetFileDetailsMethod;
    if ((getGetFileDetailsMethod = IndexServiceGrpc.getGetFileDetailsMethod) == null) {
      synchronized (IndexServiceGrpc.class) {
        if ((getGetFileDetailsMethod = IndexServiceGrpc.getGetFileDetailsMethod) == null) {
          IndexServiceGrpc.getGetFileDetailsMethod = getGetFileDetailsMethod =
              io.grpc.MethodDescriptor.<com.demo.jdfs.master.stubs.FileRequest, com.demo.jdfs.master.stubs.FileIndexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFileDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.master.stubs.FileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.master.stubs.FileIndexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IndexServiceMethodDescriptorSupplier("getFileDetails"))
              .build();
        }
      }
    }
    return getGetFileDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.CreateOrEditFileRequest,
      com.demo.jdfs.master.stubs.FileIndexResponse> getPutFilesDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "putFilesDetails",
      requestType = com.demo.jdfs.master.stubs.CreateOrEditFileRequest.class,
      responseType = com.demo.jdfs.master.stubs.FileIndexResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.CreateOrEditFileRequest,
      com.demo.jdfs.master.stubs.FileIndexResponse> getPutFilesDetailsMethod() {
    io.grpc.MethodDescriptor<com.demo.jdfs.master.stubs.CreateOrEditFileRequest, com.demo.jdfs.master.stubs.FileIndexResponse> getPutFilesDetailsMethod;
    if ((getPutFilesDetailsMethod = IndexServiceGrpc.getPutFilesDetailsMethod) == null) {
      synchronized (IndexServiceGrpc.class) {
        if ((getPutFilesDetailsMethod = IndexServiceGrpc.getPutFilesDetailsMethod) == null) {
          IndexServiceGrpc.getPutFilesDetailsMethod = getPutFilesDetailsMethod =
              io.grpc.MethodDescriptor.<com.demo.jdfs.master.stubs.CreateOrEditFileRequest, com.demo.jdfs.master.stubs.FileIndexResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "putFilesDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.master.stubs.CreateOrEditFileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.demo.jdfs.master.stubs.FileIndexResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IndexServiceMethodDescriptorSupplier("putFilesDetails"))
              .build();
        }
      }
    }
    return getPutFilesDetailsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IndexServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IndexServiceStub>() {
        @java.lang.Override
        public IndexServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IndexServiceStub(channel, callOptions);
        }
      };
    return IndexServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IndexServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IndexServiceBlockingStub>() {
        @java.lang.Override
        public IndexServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IndexServiceBlockingStub(channel, callOptions);
        }
      };
    return IndexServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IndexServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IndexServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IndexServiceFutureStub>() {
        @java.lang.Override
        public IndexServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IndexServiceFutureStub(channel, callOptions);
        }
      };
    return IndexServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class IndexServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFileDetails(com.demo.jdfs.master.stubs.FileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFileDetailsMethod(), responseObserver);
    }

    /**
     */
    public void putFilesDetails(com.demo.jdfs.master.stubs.CreateOrEditFileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutFilesDetailsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFileDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.demo.jdfs.master.stubs.FileRequest,
                com.demo.jdfs.master.stubs.FileIndexResponse>(
                  this, METHODID_GET_FILE_DETAILS)))
          .addMethod(
            getPutFilesDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.demo.jdfs.master.stubs.CreateOrEditFileRequest,
                com.demo.jdfs.master.stubs.FileIndexResponse>(
                  this, METHODID_PUT_FILES_DETAILS)))
          .build();
    }
  }

  /**
   */
  public static final class IndexServiceStub extends io.grpc.stub.AbstractAsyncStub<IndexServiceStub> {
    private IndexServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFileDetails(com.demo.jdfs.master.stubs.FileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putFilesDetails(com.demo.jdfs.master.stubs.CreateOrEditFileRequest request,
        io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutFilesDetailsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class IndexServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<IndexServiceBlockingStub> {
    private IndexServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.demo.jdfs.master.stubs.FileIndexResponse getFileDetails(com.demo.jdfs.master.stubs.FileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFileDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.demo.jdfs.master.stubs.FileIndexResponse putFilesDetails(com.demo.jdfs.master.stubs.CreateOrEditFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutFilesDetailsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class IndexServiceFutureStub extends io.grpc.stub.AbstractFutureStub<IndexServiceFutureStub> {
    private IndexServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IndexServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IndexServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.jdfs.master.stubs.FileIndexResponse> getFileDetails(
        com.demo.jdfs.master.stubs.FileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFileDetailsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.demo.jdfs.master.stubs.FileIndexResponse> putFilesDetails(
        com.demo.jdfs.master.stubs.CreateOrEditFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutFilesDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FILE_DETAILS = 0;
  private static final int METHODID_PUT_FILES_DETAILS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IndexServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IndexServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FILE_DETAILS:
          serviceImpl.getFileDetails((com.demo.jdfs.master.stubs.FileRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse>) responseObserver);
          break;
        case METHODID_PUT_FILES_DETAILS:
          serviceImpl.putFilesDetails((com.demo.jdfs.master.stubs.CreateOrEditFileRequest) request,
              (io.grpc.stub.StreamObserver<com.demo.jdfs.master.stubs.FileIndexResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class IndexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IndexServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.demo.jdfs.master.stubs.Master.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IndexService");
    }
  }

  private static final class IndexServiceFileDescriptorSupplier
      extends IndexServiceBaseDescriptorSupplier {
    IndexServiceFileDescriptorSupplier() {}
  }

  private static final class IndexServiceMethodDescriptorSupplier
      extends IndexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IndexServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IndexServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IndexServiceFileDescriptorSupplier())
              .addMethod(getGetFileDetailsMethod())
              .addMethod(getPutFilesDetailsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
