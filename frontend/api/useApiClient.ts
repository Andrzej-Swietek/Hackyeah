import axios from "axios";
import { NuxtRuntimeConfig } from "@nuxt/types/config/runtime";
import { UseFetchOptions } from "nuxt/dist/app";
import { getTokenFromLocalStorage } from "~/helpers/auth";

interface ApiClientOptions {
    withAuthorization?: boolean;
    withFiles?: boolean;
}

const API_CLIENT_DEFAULT_OPTIONS: ApiClientOptions = {
    withAuthorization: true,
    withFiles: false,
};

const getUserApiOpitions = (apiOpts: ApiClientOptions): ApiClientOptions => {
    return { ...API_CLIENT_DEFAULT_OPTIONS, ...apiOpts };
};

const getHeaders = (apiOpts: ApiClientOptions = {}) => {
    const headers: any = {};

    const apiOptions = getUserApiOpitions(apiOpts);

    if (apiOptions.withAuthorization) {
        // headers["Authorization"] = `Bearer ${getTokenFromLocalStorage()}`;
        const token = $keycloak?.token ?? '';
        headers["Authorization"] = `Bearer ${token}`;
    }

    headers["accept"] = "application/json";
    headers["x-timezone"] = Intl.DateTimeFormat().resolvedOptions().timeZone;

    return headers;
};

const useFetchClient = (
    config: NuxtRuntimeConfig,
    path: string,
    opts: UseFetchOptions<any> = {},
    apiOpts: ApiClientOptions = {}
) => {
    const headers = getHeaders(apiOpts);
    const options = { ...opts, headers };

    return useFetch(path, {
        baseURL: config.public.API_URL,
        method: options.method,
        ...options,
    });
};

const axiosClient = (
    config: NuxtRuntimeConfig,
    path: string,
    opts: UseFetchOptions<any> = {},
    apiOpts: ApiClientOptions = {},
    axiosOptions: any
) => {
    const headers = getHeaders(apiOpts);
    const options = { ...opts, headers };

    return axios({
        baseURL: config.public.API_URL,
        url: path,
        method: options.method as string,
        headers,
        ...axiosOptions
    });
};

const useApiClient = async <T>(
    path: string,
    opts: UseFetchOptions<any> = {},
    apiOpts: ApiClientOptions = {},
    useAxios: boolean = false,
    axiosOptions: {} = {}
): Promise<T> => {
    const config = useRuntimeConfig();

    if (useAxios) {
        return axiosClient<T>(config, path, opts, apiOpts, axiosOptions);
    } else {
        return useFetchClient<T>(config, path, opts, apiOpts);
    }
};

export default useApiClient;