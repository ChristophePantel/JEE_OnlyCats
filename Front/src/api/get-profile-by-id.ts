import { AccountType } from '../types/account.type';

export async function getProfileById(id: string) {
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + `/account/${id}`);
    if (result.ok) {
        try {
            const json = (await result.json()) as AccountType;
            return json;
        } catch (e) {
            return null;
        }
    }
    return null;
}
