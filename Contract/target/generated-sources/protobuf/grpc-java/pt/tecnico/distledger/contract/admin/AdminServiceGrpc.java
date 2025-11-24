package pt.tecnico.distledger.contract.admin;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: Admin_DistLedger.proto")
public final class AdminServiceGrpc {

  private AdminServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.tecnico.distledger.grpc.admin.AdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> getActivateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "activate",
      requestType = pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest.class,
      responseType = pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> getActivateMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> getActivateMethod;
    if ((getActivateMethod = AdminServiceGrpc.getActivateMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getActivateMethod = AdminServiceGrpc.getActivateMethod) == null) {
          AdminServiceGrpc.getActivateMethod = getActivateMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "activate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("activate"))
              .build();
        }
      }
    }
    return getActivateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> getDeactivateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deactivate",
      requestType = pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest.class,
      responseType = pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> getDeactivateMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> getDeactivateMethod;
    if ((getDeactivateMethod = AdminServiceGrpc.getDeactivateMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getDeactivateMethod = AdminServiceGrpc.getDeactivateMethod) == null) {
          AdminServiceGrpc.getDeactivateMethod = getDeactivateMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deactivate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("deactivate"))
              .build();
        }
      }
    }
    return getDeactivateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> getGossipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "gossip",
      requestType = pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest.class,
      responseType = pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> getGossipMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> getGossipMethod;
    if ((getGossipMethod = AdminServiceGrpc.getGossipMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getGossipMethod = AdminServiceGrpc.getGossipMethod) == null) {
          AdminServiceGrpc.getGossipMethod = getGossipMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "gossip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("gossip"))
              .build();
        }
      }
    }
    return getGossipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> getGetLedgerStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLedgerState",
      requestType = pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest.class,
      responseType = pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest,
      pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> getGetLedgerStateMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> getGetLedgerStateMethod;
    if ((getGetLedgerStateMethod = AdminServiceGrpc.getGetLedgerStateMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getGetLedgerStateMethod = AdminServiceGrpc.getGetLedgerStateMethod) == null) {
          AdminServiceGrpc.getGetLedgerStateMethod = getGetLedgerStateMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest, pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLedgerState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("getLedgerState"))
              .build();
        }
      }
    }
    return getGetLedgerStateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceStub>() {
        @java.lang.Override
        public AdminServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceStub(channel, callOptions);
        }
      };
    return AdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingStub>() {
        @java.lang.Override
        public AdminServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceBlockingStub(channel, callOptions);
        }
      };
    return AdminServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceFutureStub>() {
        @java.lang.Override
        public AdminServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceFutureStub(channel, callOptions);
        }
      };
    return AdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AdminServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void activate(pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getActivateMethod(), responseObserver);
    }

    /**
     */
    public void deactivate(pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeactivateMethod(), responseObserver);
    }

    /**
     */
    public void gossip(pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGossipMethod(), responseObserver);
    }

    /**
     */
    public void getLedgerState(pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLedgerStateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest,
                pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse>(
                  this, METHODID_ACTIVATE)))
          .addMethod(
            getDeactivateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest,
                pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse>(
                  this, METHODID_DEACTIVATE)))
          .addMethod(
            getGossipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest,
                pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse>(
                  this, METHODID_GOSSIP)))
          .addMethod(
            getGetLedgerStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest,
                pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse>(
                  this, METHODID_GET_LEDGER_STATE)))
          .build();
    }
  }

  /**
   */
  public static final class AdminServiceStub extends io.grpc.stub.AbstractAsyncStub<AdminServiceStub> {
    private AdminServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceStub(channel, callOptions);
    }

    /**
     */
    public void activate(pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActivateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deactivate(pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeactivateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void gossip(pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGossipMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLedgerState(pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLedgerStateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdminServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AdminServiceBlockingStub> {
    private AdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse activate(pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActivateMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse deactivate(pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeactivateMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse gossip(pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGossipMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse getLedgerState(pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLedgerStateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdminServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AdminServiceFutureStub> {
    private AdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse> activate(
        pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActivateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse> deactivate(
        pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeactivateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse> gossip(
        pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGossipMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse> getLedgerState(
        pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLedgerStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE = 0;
  private static final int METHODID_DEACTIVATE = 1;
  private static final int METHODID_GOSSIP = 2;
  private static final int METHODID_GET_LEDGER_STATE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE:
          serviceImpl.activate((pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.ActivateResponse>) responseObserver);
          break;
        case METHODID_DEACTIVATE:
          serviceImpl.deactivate((pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.DeactivateResponse>) responseObserver);
          break;
        case METHODID_GOSSIP:
          serviceImpl.gossip((pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.GossipResponse>) responseObserver);
          break;
        case METHODID_GET_LEDGER_STATE:
          serviceImpl.getLedgerState((pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.admin.AdminDistLedger.getLedgerStateResponse>) responseObserver);
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

  private static abstract class AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.tecnico.distledger.contract.admin.AdminDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdminService");
    }
  }

  private static final class AdminServiceFileDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier {
    AdminServiceFileDescriptorSupplier() {}
  }

  private static final class AdminServiceMethodDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdminServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminServiceFileDescriptorSupplier())
              .addMethod(getActivateMethod())
              .addMethod(getDeactivateMethod())
              .addMethod(getGossipMethod())
              .addMethod(getGetLedgerStateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
