package pt.tecnico.distledger.contract.namingserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: NamingServer_DistLedger.proto")
public final class NamingServiceGrpc {

  private NamingServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.tecnico.distledger.grpc.namingserver.NamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest.class,
      responseType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = NamingServiceGrpc.getRegisterMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getRegisterMethod = NamingServiceGrpc.getRegisterMethod) == null) {
          NamingServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lookup",
      requestType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest.class,
      responseType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> getLookupMethod;
    if ((getLookupMethod = NamingServiceGrpc.getLookupMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getLookupMethod = NamingServiceGrpc.getLookupMethod) == null) {
          NamingServiceGrpc.getLookupMethod = getLookupMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "lookup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("lookup"))
              .build();
        }
      }
    }
    return getLookupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> getGetSubscribersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSubscribers",
      requestType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest.class,
      responseType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> getGetSubscribersMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> getGetSubscribersMethod;
    if ((getGetSubscribersMethod = NamingServiceGrpc.getGetSubscribersMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getGetSubscribersMethod = NamingServiceGrpc.getGetSubscribersMethod) == null) {
          NamingServiceGrpc.getGetSubscribersMethod = getGetSubscribersMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSubscribers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("getSubscribers"))
              .build();
        }
      }
    }
    return getGetSubscribersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "delete",
      requestType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest.class,
      responseType = pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
      pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = NamingServiceGrpc.getDeleteMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getDeleteMethod = NamingServiceGrpc.getDeleteMethod) == null) {
          NamingServiceGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest, pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServiceStub>() {
        @java.lang.Override
        public NamingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServiceStub(channel, callOptions);
        }
      };
    return NamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServiceBlockingStub>() {
        @java.lang.Override
        public NamingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServiceBlockingStub(channel, callOptions);
        }
      };
    return NamingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NamingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NamingServiceFutureStub>() {
        @java.lang.Override
        public NamingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NamingServiceFutureStub(channel, callOptions);
        }
      };
    return NamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class NamingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void lookup(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupMethod(), responseObserver);
    }

    /**
     */
    public void getSubscribers(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubscribersMethod(), responseObserver);
    }

    /**
     */
    public void delete(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest,
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getLookupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest,
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>(
                  this, METHODID_LOOKUP)))
          .addMethod(
            getGetSubscribersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest,
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse>(
                  this, METHODID_GET_SUBSCRIBERS)))
          .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest,
                pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class NamingServiceStub extends io.grpc.stub.AbstractAsyncStub<NamingServiceStub> {
    private NamingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lookup(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSubscribers(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSubscribersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class NamingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<NamingServiceBlockingStub> {
    private NamingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse register(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse lookup(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse getSubscribers(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSubscribersMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse delete(pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class NamingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<NamingServiceFutureStub> {
    private NamingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NamingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse> register(
        pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse> lookup(
        pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse> getSubscribers(
        pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSubscribersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse> delete(
        pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOOKUP = 1;
  private static final int METHODID_GET_SUBSCRIBERS = 2;
  private static final int METHODID_DELETE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NamingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NamingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.RegisterResponse>) responseObserver);
          break;
        case METHODID_LOOKUP:
          serviceImpl.lookup((pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.LookupResponse>) responseObserver);
          break;
        case METHODID_GET_SUBSCRIBERS:
          serviceImpl.getSubscribers((pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.SubscriberResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.DeleteResponse>) responseObserver);
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

  private static abstract class NamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.tecnico.distledger.contract.namingserver.NamingServerDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NamingService");
    }
  }

  private static final class NamingServiceFileDescriptorSupplier
      extends NamingServiceBaseDescriptorSupplier {
    NamingServiceFileDescriptorSupplier() {}
  }

  private static final class NamingServiceMethodDescriptorSupplier
      extends NamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NamingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (NamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NamingServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getLookupMethod())
              .addMethod(getGetSubscribersMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
