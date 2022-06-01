import { HeartIcon, BookmarkIcon, ChatIcon } from '@heroicons/react/outline';
import {
    HeartIcon as HeartIconFilled,
    BookmarkIcon as BookmarkIconFIlled,
    PaperAirplaneIcon,
    ChevronRightIcon,
} from '@heroicons/react/solid';
import { Link } from 'react-router-dom';
import { postType } from '../types/post.type';
import { generateAvatar } from '../utils/generate-avatar';
import PlaceholderCatIcon from '../assets/cat.png';
import { useState } from 'react';
import { createComment } from '../api/create-comment';
import { useStore } from '../context/user.store';
import { QueryObserverResult, RefetchOptions, RefetchQueryFilters, useQuery } from 'react-query';
import { createLike, deleteLike } from '../api/create-like';
import { createBookmark, deleteBookmark } from '../api/create-bookmark';

type Props = {
    post: postType;
    displayComments: boolean;
    refetch?: <TPageData>(
        options?: (RefetchOptions & RefetchQueryFilters<TPageData>) | undefined,
    ) => Promise<QueryObserverResult<any | null, unknown>>;
};

const Post: React.FC<Props> = (props) => {
    const creatorAvatar = generateAvatar(props.post.account.id);

    const [comment, setComment] = useState('');
    const userId = useStore((state) => state.user?.id);

    const handleComment = async () => {
        if (!comment) return;
        const newComment = await createComment(userId!, props.post.id, comment);
        props.refetch && props.refetch();
    };

    const handleLike = async (isLiked: boolean) => {
        if (!isLiked) {
            await createLike(userId!, props.post.id);
        } else {
            await deleteLike(userId!, props.post.id);
        }
        props.refetch && props.refetch();
    };

    const handleBookmark = async (isBookmarked: boolean) => {
        if (!isBookmarked) {
            await createBookmark(userId!, props.post.id);
        } else {
            await deleteBookmark(userId!, props.post.id);
        }
        props.refetch && props.refetch();
    };

    return (
        <div className="flex w-full flex-col border-b border-b-gray-300">
            <div className="flex flex-row items-center">
                <Link to={`/profile/${props.post.account.id}`} className="flex flex-row items-center gap-3 py-3 px-4">
                    <img src={creatorAvatar} alt="avatar" className="h-12 w-12 rounded-full border" />
                    <p className="font-semibold text-gray-900">{props.post.account.username}</p>
                </Link>
                <ChevronRightIcon className="h-6 w-6 text-gray-500" />
                <Link to={`/cat/${props.post.cat.id}`} className="flex flex-row items-center gap-3 py-3 px-4">
                    <img
                        src={props.post.cat.image ?? PlaceholderCatIcon}
                        alt="cat"
                        className="h-12 w-12 rounded-full object-cover"
                    />
                    <p className="font-semibold text-gray-900">{props.post.cat.name}</p>
                </Link>
            </div>
            {props.post.text && <p className="px-4 py-2">{props.post.text}</p>}
            {props.post.image && <img src={props.post.image} alt="post" className="aspect-video h-80 object-cover" />}
            <div className="flex flex-row items-center gap-5 py-3 px-4">
                <div className="flex flex-row items-center gap-3">
                    {props.post.likes.find((l) => l.account.id === userId) ? (
                        <HeartIconFilled
                            onClick={() => handleLike(true)}
                            className="h-6 w-6 cursor-pointer text-gray-900 hover:text-gray-900"
                        />
                    ) : (
                        <HeartIcon
                            onClick={() => handleLike(false)}
                            className="h-6 w-6 cursor-pointer text-gray-300 hover:text-gray-900"
                        />
                    )}
                    <p className="text-sm text-gray-400">{props.post.likes?.length}</p>
                </div>
                <Link to={`/Post/${props.post.id}`} className="flex flex-row items-center gap-3">
                    <ChatIcon className="h-6 w-6 cursor-pointer text-gray-300 hover:text-gray-900" />
                    <p className="text-sm text-gray-400">{props.post.comments?.length}</p>
                </Link>
                <BookmarkIcon
                    onClick={() => handleBookmark(false)}
                    className="ml-auto h-6 w-6 cursor-pointer text-gray-300 hover:text-gray-900"
                />
            </div>
            {props.displayComments && (
                <div className="flex flex-col gap-3 px-4 py-3">
                    <div className="flex flex-row gap-3">
                        <input
                            value={comment}
                            onChange={(e) => setComment(e.target.value)}
                            className="w-full rounded-lg border py-2 px-4"
                            placeholder="Share a comment"
                        />
                        <PaperAirplaneIcon onClick={handleComment} className="h-8 w-8 rotate-45 cursor-pointer" />
                    </div>
                    <div className="flex flex-col justify-center gap-5 py-3 px-4">
                        {props.post.comments?.map((comment) => {
                            const avatar = generateAvatar(comment.account.id);
                            return (
                                <div key={comment.id} className="flex flex-row items-center gap-3">
                                    <img src={avatar} alt="avatar" className="h-8 w-8 rounded-full" />
                                    <div className="flex flex-col justify-center">
                                        <Link
                                            to={`/profile/${comment.account.id}`}
                                            className="text-xs font-semibold text-gray-900"
                                        >
                                            {comment.account.username}
                                        </Link>
                                        <p className="text-bases text-gray-500">{comment.text}</p>
                                    </div>
                                </div>
                            );
                        })}
                    </div>
                </div>
            )}
        </div>
    );
};

export default Post;
