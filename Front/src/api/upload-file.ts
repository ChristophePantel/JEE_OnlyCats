export type FileType = {
    fileDownloadUri: string;
    fileName: string;
    fileType: string;
};

export async function uploadFile(file: File) {
    const data = new FormData();
    data.append('file', file);
    const result = await fetch(import.meta.env.VITE_API_ENDPOINT + '/files/uploadFile', {
        method: 'post',
        body: data,
    });
    if (result.ok) {
        return (await result.json()) as FileType;
    }
}
