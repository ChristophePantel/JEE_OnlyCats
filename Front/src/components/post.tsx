import { HeartIcon, BookmarkIcon, ChatIcon } from '@heroicons/react/outline';
import {
    HeartIcon as HeartIconFilled,
    BookmarkIcon as BookmarkIconFIlled,
    PaperAirplaneIcon,
} from '@heroicons/react/solid';
import { Link } from 'react-router-dom';
import { postType } from '../types/post.type';
import { generateAvatar } from '../utils/generate-avatar';

type Props = {
    data: postType;
    displayComments: boolean;
};

const Post: React.FC<Props> = (props) => {
    // todo: send comment to server
    // todo: get if is liked
    // todo: send like to server

    const creatorAvatar = generateAvatar(props.data.profile.id);
    return (
        <div className="flex w-full flex-col border-b border-b-gray-300">
            <Link to={`/profile/${props.data.profile.id}`} className="flex flex-row items-center gap-3 py-3 px-4">
                <img src={creatorAvatar} alt="avatar" className="h-12 w-12 rounded-full" />
                <p className="font-semibold text-gray-900">{props.data.profile.name}</p>
            </Link>
            {props.data.post.text && <p className="px-4 py-2">{props.data.post.text}</p>}
            {props.data.post.image && (
                <img src={props.data.post.image} alt="post" className="aspect-video h-80 object-cover" />
            )}
            <div className="flex flex-row items-center gap-5 py-3 px-4">
                <div className="flex flex-row items-center gap-3">
                    <HeartIcon className="h-6 w-6 cursor-pointer text-gray-300 hover:text-black" />
                    <p className="text-sm text-gray-400">{props.data.post.likes.length}</p>
                </div>
                <Link to={`/Post/${props.data.id}`} className="flex flex-row items-center gap-3">
                    <ChatIcon className="h-6 w-6 cursor-pointer text-gray-300 hover:text-black" />
                    <p className="text-sm text-gray-400">{props.data.post.comment.length}</p>
                </Link>
                <BookmarkIcon className="ml-auto h-6 w-6 cursor-pointer text-gray-300 hover:text-black" />
            </div>
            {props.displayComments && (
                <div className="flex flex-col px-4 py-3">
                    <div className="flex flex-col justify-center gap-5 py-3 px-4">
                        {props.data.post.comment.map((comment) => {
                            const avatar = generateAvatar(comment.profile.id);
                            return (
                                <div key={comment.id} className="flex flex-row items-center gap-3">
                                    <img src={avatar} alt="avatar" className="h-8 w-8 rounded-full" />
                                    <div className="flex flex-col justify-center">
                                        <Link
                                            to={`/profile/${comment.profile.id}`}
                                            className="text-xs font-semibold text-gray-900"
                                        >
                                            {comment.profile.name}
                                        </Link>
                                        <p className="text-bases text-gray-500">{comment.text}</p>
                                    </div>
                                </div>
                            );
                        })}
                    </div>
                    <div className="flex flex-row gap-3">
                        <input className="w-full rounded-lg border py-2 px-4" placeholder="Share a comment" />
                        <PaperAirplaneIcon className="h-8 w-8 rotate-45 cursor-pointer" />
                    </div>
                </div>
            )}
        </div>
    );
};

export default Post;
