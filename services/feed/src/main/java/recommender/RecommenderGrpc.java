package recommender;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The recommender service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: src/main/resources/proto/recommender.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecommenderGrpc {

  private RecommenderGrpc() {}

  public static final java.lang.String SERVICE_NAME = "recommender.Recommender";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<recommender.RecommenderOuterClass.RecommendationRequest,
      recommender.RecommenderOuterClass.RecommendationResponse> getGetRecommendationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendations",
      requestType = recommender.RecommenderOuterClass.RecommendationRequest.class,
      responseType = recommender.RecommenderOuterClass.RecommendationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<recommender.RecommenderOuterClass.RecommendationRequest,
      recommender.RecommenderOuterClass.RecommendationResponse> getGetRecommendationsMethod() {
    io.grpc.MethodDescriptor<recommender.RecommenderOuterClass.RecommendationRequest, recommender.RecommenderOuterClass.RecommendationResponse> getGetRecommendationsMethod;
    if ((getGetRecommendationsMethod = RecommenderGrpc.getGetRecommendationsMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetRecommendationsMethod = RecommenderGrpc.getGetRecommendationsMethod) == null) {
          RecommenderGrpc.getGetRecommendationsMethod = getGetRecommendationsMethod =
              io.grpc.MethodDescriptor.<recommender.RecommenderOuterClass.RecommendationRequest, recommender.RecommenderOuterClass.RecommendationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  recommender.RecommenderOuterClass.RecommendationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  recommender.RecommenderOuterClass.RecommendationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetRecommendations"))
              .build();
        }
      }
    }
    return getGetRecommendationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecommenderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderStub>() {
        @java.lang.Override
        public RecommenderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderStub(channel, callOptions);
        }
      };
    return RecommenderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommenderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub>() {
        @java.lang.Override
        public RecommenderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderBlockingStub(channel, callOptions);
        }
      };
    return RecommenderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecommenderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub>() {
        @java.lang.Override
        public RecommenderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderFutureStub(channel, callOptions);
        }
      };
    return RecommenderFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The recommender service definition.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Sends a recommendation request and returns a list of recommended items.
     * </pre>
     */
    default void getRecommendations(recommender.RecommenderOuterClass.RecommendationRequest request,
        io.grpc.stub.StreamObserver<recommender.RecommenderOuterClass.RecommendationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Recommender.
   * <pre>
   * The recommender service definition.
   * </pre>
   */
  public static abstract class RecommenderImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RecommenderGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Recommender.
   * <pre>
   * The recommender service definition.
   * </pre>
   */
  public static final class RecommenderStub
      extends io.grpc.stub.AbstractAsyncStub<RecommenderStub> {
    private RecommenderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a recommendation request and returns a list of recommended items.
     * </pre>
     */
    public void getRecommendations(recommender.RecommenderOuterClass.RecommendationRequest request,
        io.grpc.stub.StreamObserver<recommender.RecommenderOuterClass.RecommendationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommendationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Recommender.
   * <pre>
   * The recommender service definition.
   * </pre>
   */
  public static final class RecommenderBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecommenderBlockingStub> {
    private RecommenderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a recommendation request and returns a list of recommended items.
     * </pre>
     */
    public recommender.RecommenderOuterClass.RecommendationResponse getRecommendations(recommender.RecommenderOuterClass.RecommendationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommendationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Recommender.
   * <pre>
   * The recommender service definition.
   * </pre>
   */
  public static final class RecommenderFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecommenderFutureStub> {
    private RecommenderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a recommendation request and returns a list of recommended items.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<recommender.RecommenderOuterClass.RecommendationResponse> getRecommendations(
        recommender.RecommenderOuterClass.RecommendationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommendationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RECOMMENDATIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RECOMMENDATIONS:
          serviceImpl.getRecommendations((recommender.RecommenderOuterClass.RecommendationRequest) request,
              (io.grpc.stub.StreamObserver<recommender.RecommenderOuterClass.RecommendationResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetRecommendationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              recommender.RecommenderOuterClass.RecommendationRequest,
              recommender.RecommenderOuterClass.RecommendationResponse>(
                service, METHODID_GET_RECOMMENDATIONS)))
        .build();
  }

  private static abstract class RecommenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommenderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return recommender.RecommenderOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Recommender");
    }
  }

  private static final class RecommenderFileDescriptorSupplier
      extends RecommenderBaseDescriptorSupplier {
    RecommenderFileDescriptorSupplier() {}
  }

  private static final class RecommenderMethodDescriptorSupplier
      extends RecommenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecommenderMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RecommenderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecommenderFileDescriptorSupplier())
              .addMethod(getGetRecommendationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
