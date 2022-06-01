import { postType } from '../types/post.type';

export async function getPostsByAccount(id: string) {
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + `/posts/by_profile/${id}`);
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
