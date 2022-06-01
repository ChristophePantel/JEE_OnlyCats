import { postType } from '../types/post.type';

export async function getFeedPosts(id_account: number) {
    const params = {
        id_account,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/posts/', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as postType[];
    }
}
