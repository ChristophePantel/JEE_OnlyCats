import { BookmarkType } from '../types/bookmark.type';

export async function createBookmark(id_account: number, id_post: number) {
    const params = {
        id_account,
        id_post,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/bookmarks/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as BookmarkType;
    }
}

export async function deleteBookmark(id_account: number, id_post: number) {
    const params = {
        id_account,
        id_post,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/bookmarks/delete', {
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
