import { Link, useNavigate, useParams } from 'react-router-dom';
import { CatType } from '../types/cat.type';
import { generateAvatar } from '../utils/generate-avatar';
import { CurrencyDollarIcon, MinusSmIcon, PlusSmIcon } from '@heroicons/react/outline';
import { postType } from '../types/post.type';
import Post from '../components/post';
import { useEffect, useState } from 'react';
import { getProfileById } from '../api/get-profile-by-id';
import { useStore } from '../context/user.store';
import CreateNewCat from '../components/create-new-cat';
import { getCatById } from '../api/get-cat-by-id';
import placeholderIcon from '../assets/cat.png';
import { getPostsByCat } from '../api/get-posts-by-cat';
import { createSubscription, deleteSubscription } from '../api/create-subscription';
import { useQuery } from 'react-query';

const Cat: React.FC = (props) => {
    const navigate = useNavigate();

    const { id } = useParams();
    const user = useStore((state) => state.user);
    const refetchUser = useStore((state) => state.refetch);

    const { data: cat } = useQuery(['cat', id], async () => getCatById(id!));
    const { data: posts, refetch } = useQuery(['cat_posts', id], async () => getPostsByCat(id!));

    const avatar = cat?.image ?? placeholderIcon;
    const getLikes = () => {
        return posts ? posts.map((p) => p.likes).flat().length : 0;
    };

    const getPostsNumber = () => {
        return posts ? posts.length : 0;
    };

    const handleSubscribe = async (isSubscribed: boolean) => {
        if (!isSubscribed) {
            await createSubscription(user?.id!, cat?.id!);
        } else {
            await deleteSubscription(user?.id!, cat?.id!);
        }
        await refetchUser();
    };

    return (
        <div className="flex w-full flex-col items-center gap-5">
            <div className="h-20 w-full bg-gray-200" />
            <img alt="avatar" src={avatar} className="h-20 w-20 -translate-y-14 rounded-full border" />
            <p className="-translate-y-14 font-semibold">{cat?.name}</p>
            <div className="flex -translate-y-14 flex-row gap-4">
                {!user?.subs?.find((s) => `${s.cat.id}` == id!) ? (
                    <button
                        onClick={() => handleSubscribe(false)}
                        className="flex flex-row items-center gap-2 rounded-lg bg-blue-400 py-2 px-4 font-bold text-white"
                    >
                        <PlusSmIcon className="h-5 w-5" />
                        <p>Subscribe</p>
                    </button>
                ) : (
                    <button
                        onClick={() => handleSubscribe(true)}
                        className="flex flex-row items-center gap-2 rounded-lg border py-2 px-4 font-bold text-gray-500"
                    >
                        <MinusSmIcon className="h-5 w-5" />
                        <p>Unsubscribe</p>
                    </button>
                )}
            </div>
            <div className="flex -translate-y-14 flex-row gap-4">
                <div className="flex flex-col items-center">
                    <p className="text-xs">Posts</p>
                    <p className="font-bold">{getPostsNumber()}</p>
                </div>
                <div className="flex flex-col items-center">
                    <p className="text-xs">Likes</p>
                    <p className="font-bold">{getLikes()}</p>
                </div>
            </div>
            <hr className="w-full -translate-y-14" />
            <div className="flex w-full -translate-y-14 flex-col">
                {posts &&
                    posts.map((post) => <Post key={post.id} post={post} displayComments={false} refetch={refetch} />)}
            </div>
        </div>
    );
};

export default Cat;
