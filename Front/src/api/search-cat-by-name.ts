import { CatType } from '../types/cat.type';
import { postType } from '../types/post.type';

export async function searchCatByName(name: string) {
    const params = {
        name,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/cats/search', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as CatType[];
    }
}
