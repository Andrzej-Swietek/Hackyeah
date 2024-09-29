import proto.recommender_pb2
import proto.recommender_pb2_grpc
from adapters.company_adapter import CompanyAdapter
from adapters.http_client_adapter import HTTPClientAdapter
from adapters.ngo_adapter import NGOAdapter
from adapters.volunteer_adapter import VolunteerAdapter


class RecommenderService(proto.recommender_pb2_grpc.RecommenderServicer):
    """
    gRPC RecommenderService that calls HTTP services based on the requester_type and requested_type.
    """

    def __init__(self):
        # Initialize the adapters for each service (HTTP-based services)
        self.company_adapter = CompanyAdapter(base_url="http://localhost:8225/api/v1/company")
        self.ngo_adapter = NGOAdapter(base_url="http://localhost:8225/api/v1/ngo", http_client=HTTPClientAdapter())
        self.volunteer_adapter = VolunteerAdapter(base_url="http://localhost:8224/api/v1/user-profiles")

    def GetRecommendations(self, request, context):
        """
        Processes gRPC requests and forwards the request to appropriate HTTP services based on
        requester_type and requested_type.
        """
        user_id = request.user_id
        requester_type = request.requester_type
        requested_type = request.requested_type

        print(user_id)
        print(requested_type)
        print(requester_type)

        recommended_items = []

        # Handle the requester type COMPANY
        if requester_type == proto.recommender_pb2.RequesterType.COMPANY:
            if requested_type == proto.recommender_pb2.RequestedType.NGO:
                # Make HTTP request to NGO service
                recommended_items = self.ngo_adapter.get_ngo_recommendations(user_id)
            elif requested_type == proto.recommender_pb2.RequestedType.VOLUNTEER:
                # Make HTTP request to Volunteer service
                recommended_items = self.volunteer_adapter.get_volunteer_recommendations(user_id)

        # Handle the requester type NGO
        elif requester_type == proto.recommender_pb2.RequesterType.NGO:
            if requested_type == proto.recommender_pb2.RequestedType.COMPANY:
                # Make HTTP request to Company service
                recommended_items = self.company_adapter.get_company_recommendations(user_id)
            elif requested_type == proto.recommender_pb2.RequestedType.VOLUNTEER:
                # Make HTTP request to Volunteer service
                recommended_items = self.volunteer_adapter.get_volunteer_recommendations(user_id)

        # Handle the requester type VOLUNTEER
        elif requester_type == proto.recommender_pb2.RequesterType.VOLUNTEER:
            if requested_type == proto.recommender_pb2.RequestedType.COMPANY:
                # Make HTTP request to Company service
                recommended_items = self.company_adapter.get_company_recommendations(user_id)
            elif requested_type == proto.recommender_pb2.RequestedType.NGO:
                # Make HTTP request to NGO service
                recommended_items = self.ngo_adapter.get_ngo_recommendations(user_id)

        # Return the gRPC response
        return proto.recommender_pb2.RecommendationResponse(recommended_items=recommended_items)

