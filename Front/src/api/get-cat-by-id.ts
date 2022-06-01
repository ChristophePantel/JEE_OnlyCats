import { CatType } from '../types/cat.type';

export async function getCatById(id: string) {
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + `/cats/${id}`);
    if (result.ok) {
        try {
            const json = (await result.json()) as CatType;
            return json;
        } catch (e) {
            return null;
        }
    }
    return null;
}
