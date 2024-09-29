from adapters.http_client_adapter import HTTPClientAdapter


class VolunteerAdapter:
    def __init__(self, base_url: str):
        self.base_url = base_url
        self.http_client = HTTPClientAdapter()

    def get_volunteer_recommendations(self):
        url = f"{self.base_url}/volunteers"

        response = self.http_client.get(url)
        if response.status_code == 200:
            print(response.json())
            return response.json()
        else:
            raise Exception(f"Failed to get recommendations: {response.status_code}, {response.text}")
