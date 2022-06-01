import { useQuery } from 'react-query';
import { useParams } from 'react-router-dom';
import { getPostById } from '../api/get-post-by-id';
import Post from '../components/post';

export default function PostPage() {
    const { id } = useParams();

    const { data, isLoading, refetch } = useQuery(['post', { id }], async () => await getPostById(id!));

    return isLoading || !data ? (
        <div className="grid w-full place-items-center p-20">Loading...</div>
    ) : (
        <Post post={data} displayComments={true} refetch={refetch} />
    );
}
