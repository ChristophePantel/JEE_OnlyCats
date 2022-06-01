import { LightningBoltIcon } from '@heroicons/react/outline';
import MainContent from '../components/main-content';
import { postType } from '../types/post.type';
import Post from '../components/post';
import { useStore } from '../context/user.store';

export default function BookmarksPage() {
    const bookmarks = useStore((state) => state.user?.bookmarks);
    return (
        <>
            <h1 className="border-b border-b-gray-300 p-3 text-2xl font-semibold">Bookmarks</h1>
            <div className="flex flex-col">
                {bookmarks
                    ?.map((b) => b.post)
                    .flat()
                    .map((post) => (
                        <Post key={post.id} post={post} displayComments={false} />
                    ))}
            </div>
        </>
    );
}
