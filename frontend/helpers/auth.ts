// Interfaces
import {Authenticatable} from "~/models/auth/autenticable.model";
import {AuthToken} from "~/models/auth/auth-token.model";

// Stores
import useUserStore, {UserState} from "~/store/user";

// Models
import {User} from "~/models/auth/User";

// Fetchers
import useGetAuthenticatedUser from "~/api/auth/useGetAuthenticatedUser"
import useFetchUserWithData from "~/api/auth/useFetchUserWithData";
import useResetPassword, {ResetPasswordPayload} from "~/api/auth/useResetPassword";

// Helpers
import { isRouteForLoggedUser } from "~/helpers/routes";


// Constants
export const STORAGE_TOKEN_KEY: string = "_token";


export const getAuthenticatedUser = async (): Promise<void> => {
    const response = await useGetAuthenticatedUser();

    if (response.data.value)
        saveUserToStore(response.data.value, response.data.value.is_admin);


    if (response.error.value)
        redirectIfUnauthenticated(response.error.value);

}


export const saveUserAndTokenToStore = (
    user: Authenticatable,
    token: AuthToken,
    isAdmin: boolean
): void => {
    const userStore = useUserStore();

    saveUserToStore(user, isAdmin);
    saveTokenToLocalStorage(token);

    userStore.$patch((state: any) => {
        state.token = token;
    });

};

export const saveUserToStore = (user: Authenticatable, isAdmin: boolean): void => {
    const userStore = useUserStore();
    userStore.$patch((state: any) => {
        state.user = user;
        state.isAdmin = isAdmin;
    });
};

export const removeUserAndToken = (): void => {
    const userStore = useUserStore();

    // Clear token from local storage or state
    removeTokenFromLocalStorage(); // Assuming you have this method to remove the token from storage

    // Clear user data from the store
    userStore.$patch((state: any) => {
        state.user = null;
        state.token = null;
        state.userElearningCourses = [];
        state.isAdmin = false;
    });
};


export const saveTokenToLocalStorage = (token: AuthToken): void => {
    localStorage.setItem(STORAGE_TOKEN_KEY, token.accessToken);
};

export const removeTokenFromLocalStorage = (): void => {
    localStorage.removeItem(STORAGE_TOKEN_KEY);
};

export const getTokenFromLocalStorage = (): string | null => {
    return localStorage.getItem(STORAGE_TOKEN_KEY);
};

export const saveUser = (user: Authenticatable): void => {
    const userStore = useUserStore();
    // const favoriteStore = useFavoriteStore();

    userStore.$patch((state: any) => {
        state.user = user;
    });

    // favoriteStore.syncFavorites();
};



/// STORE HELPERS

export const isAdmin = async (): Promise<boolean> => {
    const userStore = useUserStore();

    return userStore.$state.isAdmin == true;
};


export const isOwner = async(): Promise<boolean> => {
    const userStore = useUserStore();

    return userStore.$state.isOwner == true;
}

export const isAuth = () => {
    const userStore = useUserStore();
    return getTokenFromLocalStorage() != null && userStore.$state.user != null;
};



/// FETCHER HELPERS

export const fetchUserWithData = async (): Promise<void> => {
    const { data, error } = await useFetchUserWithData();

    if (error.value) {
        if (error.value.statusCode == 401 || error.value.statusCode == 403)
            navigateTo("/");
        return;
    }
    if (data.value) {
        updateUserWithData(data.value);
    }
    return;
};


export const updateUserPersonalInformation = (user: User): void => {
    const userStore = useUserStore();

    userStore.$patch((state: UserState) => {
        state.user = user;

        state.user.firstname = user.firstname;
        state.user.lastname = user.lastname;
        state.user.job_title = user.job_title;
        state.user.address = user.address;
        state.user.address2 = user.address2;
        state.user.city = user.city;
        state.user.state = user.state;
        state.user.area_code = user.area_code;
        state.user.country_id = user.country_id;
        state.user.phone_number = user.phone_number;
        state.user.newsletter = user.newsletter;
    });
};


export const resetPassword = async (payload: ResetPasswordPayload) => {
    const { data, error } = await useResetPassword(payload);

    if (error.value) return error.value;
    if (data.value) return data.value;
    return;
};


export const redirectIfUnauthenticated = (error: any) => {
    if (isRouteForLoggedUser() && (error.statusCode == 401 || error.statusCode == 403)) {
        removeUserAndToken();
        navigateTo("/");
    }
};