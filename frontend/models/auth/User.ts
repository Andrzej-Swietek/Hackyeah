import {Authenticatable} from "~/models/auth/autenticable.model";

export interface User extends Authenticatable {
    firstname: string;
    lastname: string;
    job_title: string;

    address: string;
    city: string,
    state: string,

    phone_number: string,
    newsletter: boolean,
    last_seen_at: string
}