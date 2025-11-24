package pt.tecnico.distledger.contract.distledgerserver;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: CrossServer_DistLedger.proto")
public final class DistLedgerCrossServerServiceGrpc {

  private DistLedgerCrossServerServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.tecnico.distledger.grpc.distledgerserver.DistLedgerCrossServerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest,
      pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> getGossipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "gossip",
      requestType = pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest.class,
      responseType = pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest,
      pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> getGossipMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest, pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> getGossipMethod;
    if ((getGossipMethod = DistLedgerCrossServerServiceGrpc.getGossipMethod) == null) {
      synchronized (DistLedgerCrossServerServiceGrpc.class) {
        if ((getGossipMethod = DistLedgerCrossServerServiceGrpc.getGossipMethod) == null) {
          DistLedgerCrossServerServiceGrpc.getGossipMethod = getGossipMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest, pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "gossip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DistLedgerCrossServerServiceMethodDescriptorSupplier("gossip"))
              .build();
        }
      }
    }
    return getGossipMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DistLedgerCrossServerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceStub>() {
        @java.lang.Override
        public DistLedgerCrossServerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistLedgerCrossServerServiceStub(channel, callOptions);
        }
      };
    return DistLedgerCrossServerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DistLedgerCrossServerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceBlockingStub>() {
        @java.lang.Override
        public DistLedgerCrossServerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistLedgerCrossServerServiceBlockingStub(channel, callOptions);
        }
      };
    return DistLedgerCrossServerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DistLedgerCrossServerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DistLedgerCrossServerServiceFutureStub>() {
        @java.lang.Override
        public DistLedgerCrossServerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DistLedgerCrossServerServiceFutureStub(channel, callOptions);
        }
      };
    return DistLedgerCrossServerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DistLedgerCrossServerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void gossip(pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGossipMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGossipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest,
                pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse>(
                  this, METHODID_GOSSIP)))
          .build();
    }
  }

  /**
   */
  public static final class DistLedgerCrossServerServiceStub extends io.grpc.stub.AbstractAsyncStub<DistLedgerCrossServerServiceStub> {
    private DistLedgerCrossServerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DistLedgerCrossServerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistLedgerCrossServerServiceStub(channel, callOptions);
    }

    /**
     */
    public void gossip(pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGossipMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DistLedgerCrossServerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DistLedgerCrossServerServiceBlockingStub> {
    private DistLedgerCrossServerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DistLedgerCrossServerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistLedgerCrossServerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse gossip(pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGossipMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DistLedgerCrossServerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DistLedgerCrossServerServiceFutureStub> {
    private DistLedgerCrossServerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DistLedgerCrossServerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DistLedgerCrossServerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse> gossip(
        pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGossipMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GOSSIP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DistLedgerCrossServerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DistLedgerCrossServerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GOSSIP:
          serviceImpl.gossip((pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.GossipResponse>) responseObserver);
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

  private static abstract class DistLedgerCrossServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DistLedgerCrossServerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.tecnico.distledger.contract.distledgerserver.CrossServerDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DistLedgerCrossServerService");
    }
  }

  private static final class DistLedgerCrossServerServiceFileDescriptorSupplier
      extends DistLedgerCrossServerServiceBaseDescriptorSupplier {
    DistLedgerCrossServerServiceFileDescriptorSupplier() {}
  }

  private static final class DistLedgerCrossServerServiceMethodDescriptorSupplier
      extends DistLedgerCrossServerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DistLedgerCrossServerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DistLedgerCrossServerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DistLedgerCrossServerServiceFileDescriptorSupplier())
              .addMethod(getGossipMethod())
              .build();
        }
      }
    }
    return result;
  }
}
