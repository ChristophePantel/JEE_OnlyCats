import { CatType } from '../types/cat.type';
import { uploadFile } from './upload-file';

export async function createCat(name: string, owner_id: number, image: File | undefined) {
    let imageUrl: string | undefined;
    if (image) {
        const fileURL = await uploadFile(image);
        imageUrl = fileURL?.fileDownloadUri;
    }
    const params = {
        name,
        owner_id,
        image: imageUrl,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/cats/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const cat = await result.json();
        return cat as CatType;
    }
}
