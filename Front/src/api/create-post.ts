import { postType } from '../types/post.type';
import { uploadFile } from './upload-file';

export async function createPost(userId: number, catId: number, text: string, image: File | undefined) {
    if (image) {
        const fileURL = await uploadFile(image);
        console.log(fileURL);
    }
}
