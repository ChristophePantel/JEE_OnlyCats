import { CommentType } from '../types/comment.type';

export async function createComment(id_account: number, id_post: number, text: string) {
    const params = {
        id_account,
        id_post,
        text,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/comments/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as CommentType;
    }
}
