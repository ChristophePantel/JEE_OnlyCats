import { LikeType } from '../types/like.type';

export async function createLike(id_account: number, id_post: number) {
    const params = {
        id_account,
        id_post,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/like/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as LikeType;
    }
}

export async function deleteLike(id_account: number, id_post: number) {
    const params = {
        id_account,
        id_post,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/like/delete', {
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
