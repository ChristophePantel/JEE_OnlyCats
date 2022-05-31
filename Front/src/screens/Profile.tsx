import { Link, useNavigate, useParams } from 'react-router-dom';
import { AccountType } from '../types/account.type';
import { generateAvatar } from '../utils/generate-avatar';
import { CurrencyDollarIcon, PlusSmIcon } from '@heroicons/react/outline';
import { postType } from '../types/post.type';
import Post from '../components/post';
import { useEffect, useState } from 'react';
import { getProfileById } from '../api/get-profile-by-id';

const Profile: React.FC = (props) => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [profile, setProfile] = useState<AccountType | null>(null);

    useEffect(() => {
        async function get() {
            const result = await getProfileById(id!);
            if (result === null) {
                navigate(-1);
            } else {
                setProfile(result);
            }
        }
        get();
    }, [id]);

    const avatar = generateAvatar(id!);
    const getLikes = () => {
        return profile ? profile.cats?.map((c) => c.posts.map((p) => p.likes.length)).flat().length : 0;
    };

    const getPostsNumber = () => {
        return profile ? profile.cats?.map((c) => c.posts.length).flat().length : 0;
    };

    const getPosts = () => {
        return profile && profile.cats ? profile.cats.map((c) => c.posts).flat() : [];
    };

    return (
        <div className="flex w-full flex-col items-center gap-5">
            <div className="h-20 w-full bg-gray-200" />
            <img alt="avatar" src={avatar} className="h-20 w-20 -translate-y-14 rounded-full border" />
            <p className="-translate-y-14 font-semibold">{profile?.username}</p>
            {/* <div className="flex -translate-y-14 flex-row gap-4">
                <button className="flex flex-row items-center gap-2 rounded-lg bg-blue-400 py-2 px-4 font-bold text-white">
                    <PlusSmIcon className="h-5 w-5" />
                    <p>Subscribe</p>
                </button>
                <button className="flex flex-row items-center gap-2 rounded-lg border-2 border-blue-400 py-2 px-4 font-bold text-blue-400">
                    <CurrencyDollarIcon className="h-5 w-5" />
                    <p>Donate</p>
                </button>
            </div> */}
            <div className="flex w-full -translate-y-14 flex-row flex-wrap justify-around gap-2">
                {profile && profile.cats && profile.cats.length ? (
                    profile.cats.map((cat) => (
                        <Link to={`/cat/${cat.id}`} className="flex cursor-pointer flex-col items-center">
                            <img src={cat.image} alt="cat" className="h-10 w-10 rounded-full" />
                            <p className="text-sm font-normal">{cat.name}</p>
                        </Link>
                    ))
                ) : (
                    <p className="text-sm font-normal text-gray-500">No cats</p>
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
                {getPosts().map((post) => (
                    <Post key={post.id} post={post} displayComments={false} />
                ))}
            </div>
        </div>
    );
};

export default Profile;
