import { LightningBoltIcon } from '@heroicons/react/outline';
import MainContent from '../components/main-content';
import { postType } from '../types/post.type';
import Post from '../components/post';

const testPosts: postType[] = [
    {
        id: 1,
        cat: {
            id: 1,
            name: 'test cat',
            image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        },
        image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        user: {
            id: 1,
            username: 'test',
        },
        text: 'hello from pakistan',
        comments: [],
        likes: [],
        bookmarkers: [],
    },
];

export default function BookmarksPage() {
    return (
        <>
            <h1 className="border-b border-b-gray-300 p-3 text-2xl font-semibold">Bookmarks</h1>
            <div className="flex flex-col">
                {testPosts.map((post) => (
                    <Post key={post.id} post={post} displayComments={false} />
                ))}
            </div>
        </>
    );
}
