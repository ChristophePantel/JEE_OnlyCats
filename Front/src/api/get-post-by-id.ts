import { postType } from '../types/post.type';

export async function getPostById(id: string) {
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + `/posts/${id}`);
    if (result.ok) {
        try {
            const json = (await result.json()) as postType;
            return json;
        } catch (e) {
            return null;
        }
    }
    return null;
}
