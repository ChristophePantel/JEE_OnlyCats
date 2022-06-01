import { postType } from '../types/post.type';

export async function getPostsByCat(id: string) {
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + `/posts/by_cat/${id}`);
    if (result.ok) {
        try {
            const json = (await result.json()) as postType[];
            return json;
        } catch (e) {
            return null;
        }
    }
    return null;
}
