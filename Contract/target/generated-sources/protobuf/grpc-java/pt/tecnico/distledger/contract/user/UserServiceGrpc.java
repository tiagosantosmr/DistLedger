package pt.tecnico.distledger.contract.user;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: User_DistLedger.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "pt.tecnico.distledger.grpc.user.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> getBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "balance",
      requestType = pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest.class,
      responseType = pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> getBalanceMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest, pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> getBalanceMethod;
    if ((getBalanceMethod = UserServiceGrpc.getBalanceMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getBalanceMethod = UserServiceGrpc.getBalanceMethod) == null) {
          UserServiceGrpc.getBalanceMethod = getBalanceMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest, pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "balance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("balance"))
              .build();
        }
      }
    }
    return getBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createAccount",
      requestType = pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest.class,
      responseType = pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest, pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = UserServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateAccountMethod = UserServiceGrpc.getCreateAccountMethod) == null) {
          UserServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest, pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("createAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> getDeleteAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteAccount",
      requestType = pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest.class,
      responseType = pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> getDeleteAccountMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest, pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> getDeleteAccountMethod;
    if ((getDeleteAccountMethod = UserServiceGrpc.getDeleteAccountMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDeleteAccountMethod = UserServiceGrpc.getDeleteAccountMethod) == null) {
          UserServiceGrpc.getDeleteAccountMethod = getDeleteAccountMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest, pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("deleteAccount"))
              .build();
        }
      }
    }
    return getDeleteAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> getTransferToMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transferTo",
      requestType = pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest.class,
      responseType = pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest,
      pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> getTransferToMethod() {
    io.grpc.MethodDescriptor<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest, pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> getTransferToMethod;
    if ((getTransferToMethod = UserServiceGrpc.getTransferToMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getTransferToMethod = UserServiceGrpc.getTransferToMethod) == null) {
          UserServiceGrpc.getTransferToMethod = getTransferToMethod =
              io.grpc.MethodDescriptor.<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest, pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "transferTo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("transferTo"))
              .build();
        }
      }
    }
    return getTransferToMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void balance(pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBalanceMethod(), responseObserver);
    }

    /**
     */
    public void createAccount(pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    public void deleteAccount(pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccountMethod(), responseObserver);
    }

    /**
     */
    public void transferTo(pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTransferToMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBalanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest,
                pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse>(
                  this, METHODID_BALANCE)))
          .addMethod(
            getCreateAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest,
                pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse>(
                  this, METHODID_CREATE_ACCOUNT)))
          .addMethod(
            getDeleteAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest,
                pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse>(
                  this, METHODID_DELETE_ACCOUNT)))
          .addMethod(
            getTransferToMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest,
                pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse>(
                  this, METHODID_TRANSFER_TO)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void balance(pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAccount(pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAccount(pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transferTo(pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest request,
        io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTransferToMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse balance(pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBalanceMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse createAccount(pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse deleteAccount(pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse transferTo(pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTransferToMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse> balance(
        pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBalanceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse> createAccount(
        pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse> deleteAccount(
        pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse> transferTo(
        pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTransferToMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BALANCE = 0;
  private static final int METHODID_CREATE_ACCOUNT = 1;
  private static final int METHODID_DELETE_ACCOUNT = 2;
  private static final int METHODID_TRANSFER_TO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BALANCE:
          serviceImpl.balance((pt.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse>) responseObserver);
          break;
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_DELETE_ACCOUNT:
          serviceImpl.deleteAccount((pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.DeleteAccountResponse>) responseObserver);
          break;
        case METHODID_TRANSFER_TO:
          serviceImpl.transferTo((pt.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest) request,
              (io.grpc.stub.StreamObserver<pt.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return pt.tecnico.distledger.contract.user.UserDistLedger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getBalanceMethod())
              .addMethod(getCreateAccountMethod())
              .addMethod(getDeleteAccountMethod())
              .addMethod(getTransferToMethod())
              .build();
        }
      }
    }
    return result;
  }
}
