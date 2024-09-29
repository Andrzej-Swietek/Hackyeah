import {defineStore} from "pinia";

import {AuthToken} from "~/models/auth/auth-token.model";
import {User} from "~/models/auth/User";
import {Authenticatable} from "~/models/auth/autenticable.model";

export interface UserState {
    user: Authenticatable | User | Admin | null;
    token: AuthToken | null;
    isOwner: boolean;
    isAdmin: boolean;
}

const state = (): UserState => {
    return {
        user: null,
        token: null,
        isOwner: false,
        isAdmin: false,
    }
}


const useUserStore = defineStore('userStore', {
    state,
    persist: {
        storage: persistedState.localStorage,
    },
});

export default useUserStore;