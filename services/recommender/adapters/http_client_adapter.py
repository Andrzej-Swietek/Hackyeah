import requests
from typing import Dict, Any


class HTTPClientAdapter:
    def get(self, url: str, params: Dict[str, Any] = None):
        try:
            response = requests.get(url, params=params)
            response.raise_for_status()  # Raise an exception for HTTP errors
            return response.json()
        except requests.RequestException as e:
            print(f"HTTP GET request failed: {e}")
            return None

    def post(self, url: str, json_data: Dict[str, Any] = None):
        try:
            response = requests.post(url, json=json_data)
            response.raise_for_status()
            return response.json()
        except requests.RequestException as e:
            print(f"HTTP POST request failed: {e}")
            return None
