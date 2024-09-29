import useApiClient from "~/api/useApiClient";

const useFetchUserWithData = async () => {
    return useApiClient('auth/getUserWithData',
        { method: 'GET' },
        { withAuthorization: true }
    );
}

export default useFetchUserWithData;