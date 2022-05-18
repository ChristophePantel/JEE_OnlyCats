import CreateNewPost from './create-new-post';
import Post from './post';
import { LightningBoltIcon } from '@heroicons/react/outline';
import type { postType } from '../types/post.type';

type Props = {
    posts: postType[];
};

const MainContent: React.FC<Props> = (props) => {
    return (
        <>
            <h1 className="border-b border-b-gray-300 p-3 text-2xl font-semibold">Home</h1>
            <CreateNewPost />
            <div className="flex flex-col">
                {props.posts.map((post) => (
                    <Post key={post.id} data={post} displayComments={false} />
                ))}
                <div className="grid w-full place-items-center py-5">
                    <LightningBoltIcon className="h-7 w-7 animate-bounce text-gray-300" />
                </div>
            </div>
        </>
    );
};

export default MainContent;
