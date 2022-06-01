import { useQuery } from 'react-query';
import { getFeedPosts } from '../api/get-feed-posts';
import MainContent from '../components/main-content';
import { useStore } from '../context/user.store';
import { postType } from '../types/post.type';

export default function Home() {
    const userId = useStore((state) => state.user?.id);
    const { data } = useQuery('feed', async () => await getFeedPosts(userId!));
    return <MainContent posts={data || []} />;
}
