from adapters.http_client_adapter import HTTPClientAdapter


class NGOAdapter:
    def __init__(self, base_url: str, http_client):
        self.base_url = base_url
        self.http_client = http_client  # Dependency injection for better flexibility

    def get_ngo_recommendations(self):
        url = f"{self.base_url}?page=1&size=10000000"
        response = self.http_client.get(url)

        if response.status_code == 200:
            print(response.json())
            return response.json()  # Parse and return JSON data
        else:
            raise Exception(f"Failed to get recommendations: {response.status_code}, {response.text}")

