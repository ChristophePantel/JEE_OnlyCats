import { postType } from '../types/post.type';
import { uploadFile } from './upload-file';

export async function createPost(id_account: number, id_cat: number, text: string, image: File | undefined) {
    let imageUrl: string | undefined;
    if (image) {
        const fileURL = await uploadFile(image);
        imageUrl = fileURL?.fileDownloadUri;
    }
    const params = {
        account: { id: id_account },
        cat: { id: id_cat },
        text,
        image: imageUrl,
    };
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/posts/create', {
        method: 'post',
        headers: new Headers({ 'content-type': 'application/json' }),
        body: JSON.stringify(params),
    });
    if (result.ok) {
        const post = await result.json();
        return post as postType;
    }
}
