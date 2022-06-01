import create from 'zustand';
import { persist } from 'zustand/middleware';
import { AccountType } from '../types/account.type';

type SignUpParams = {
    username: string;
    email: string;
    password: string;
};

type LoginParams = {
    email: string;
    password: string;
};

export interface UserState {
    user: AccountType | null;
    signup: (params: SignUpParams) => Promise<void>;
    login: (params: LoginParams) => Promise<void>;
    logout: () => Promise<void>;
    refetch: () => Promise<void>;
}

export const useStore = create<UserState>()(
    persist(
        (set, get) => ({
            user: null,
            signup: async (params: SignUpParams) => {
                const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/account/create', {
                    method: 'POST',
                    headers: new Headers({ 'content-type': 'application/json' }),
                    body: JSON.stringify(params),
                });
                if (result.ok) {
                    const user = (await result.json()) as AccountType;
                    set({ user });
                }
            },
            login: async (params: LoginParams) => {
                const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/account/login', {
                    method: 'POST',
                    headers: new Headers({ 'content-type': 'application/json' }),
                    body: JSON.stringify(params),
                });
                if (result.ok) {
                    const user = (await result.json()) as AccountType;
                    set({ user });
                }
            },
            logout: async () => {
                set({ user: null });
            },
            refetch: async () => {
                const currUser = get().user;
                const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/account/login', {
                    method: 'POST',
                    headers: new Headers({ 'content-type': 'application/json' }),
                    body: JSON.stringify({ email: currUser?.email, password: currUser?.password }),
                });
                if (result.ok) {
                    const user = (await result.json()) as AccountType;
                    set({ user });
                }
            },
        }),
        {
            name: 'onlycats-user',
            getStorage: () => sessionStorage,
        },
    ),
);
