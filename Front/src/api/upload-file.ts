export async function uploadFile(file: File) {
    const data = new FormData();
    data.append('file', file);
    const result = await fetch(process.env.API_ENDPOINT + '/files/uploadFile', {
        method: 'post',
        body: data,
    });
    if (result.ok) {
        console.log(result);
        return (await result.json()) as string;
    }
}
