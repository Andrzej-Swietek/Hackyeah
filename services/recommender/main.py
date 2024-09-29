import grpc
from concurrent import futures
from proto import recommender_pb2_grpc  # Import the generated gRPC code
from services.recommender_service import RecommenderService  # Import your service implementation


class AppConfig:
    def __init__(self, host, port):
        self.host = host
        self.port = port


class App:
    def __init__(self, config):
        self.config = config
        # Create a gRPC server with a thread pool of 10 workers
        self.server = grpc.server(
            futures.ThreadPoolExecutor(max_workers=10)
        )

        # Add the RecommenderService to the gRPC server
        recommender_pb2_grpc.add_RecommenderServicer_to_server(
            RecommenderService(), self.server
        )

        # Bind the server to the host and port
        self.server.add_insecure_port(f"{self.config.host}:{self.config.port}")

    def start(self):
        # Start the gRPC server
        self.server.start()
        print(f"gRPC server is running on {self.config.host}:{self.config.port}")
        self.server.wait_for_termination()


if __name__ == "__main__":
    # Initialize the configuration with host and port
    config = AppConfig(host='localhost', port=50051)

    # Create and start the gRPC application
    app = App(config)
    app.start()

