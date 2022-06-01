import { LikeType } from '../types/like.type';

export async function createSubscription(id_account: number, id_cat: number) {
    const params = {
        id_account,
        id_cat,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/subs/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as LikeType;
    }
}

export async function deleteSubscription(id_account: number, id_cat: number) {
    const params = {
        id_account,
        id_cat,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/subs/delete', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        return true;
    } else {
        return false;
    }
}
