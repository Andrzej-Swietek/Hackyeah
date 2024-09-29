import useApiClient from "~/api/useApiClient";
const useGetAuthenticatedUser = async () => {
    return useApiClient(
        "auth/getAuthenticatedUser",
        { method: "GET" },
        { withAuthorization: true }
    );
};

export default useGetAuthenticatedUser;