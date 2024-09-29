import useApiClient from "~/api/useApiClient";


export interface ResetPasswordPayload {
    token: string;
    email: string;
    password: string;
    password_confirmation: string;
}

const useResetPassword = async (payload: ResetPasswordPayload) => {
    return useApiClient(`auth/reset-password`,
        {
                method: 'POST',
                body: payload
            },
        { withAuthorization: false }
    );
}

export default useResetPassword;