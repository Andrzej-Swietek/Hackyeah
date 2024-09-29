import type Keycloak from "keycloak-js";

declare module "#app" {
    interface NuxtApp {
        $keycloak: Keycloak;
    }
}

interface Sort {
    sorted: boolean;
    empty: boolean;
    unsorted: boolean;
}

interface Pageable {
    pageNumber: number;
    pageSize: number;
    sort: Sort;
    offset: number;
    paged: boolean;
    unpaged: boolean;
}

interface PageableResponse<T> {
    content: T[];
    pageable: Pageable;
    last: boolean;
    totalPages: number;
    totalElements: number;
    first: boolean;
    size: number;
    number: number;
    sort: Sort;
    numberOfElements: number;
    empty: boolean;
}