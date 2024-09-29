export interface Authenticatable {
    uuid?: string;
    email: string;
    is_admin?: boolean;
    is_owner?:boolean;
    deleted_at?: string;
}