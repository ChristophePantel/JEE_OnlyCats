import { Link, useNavigate, useParams } from 'react-router-dom';
import { AccountType } from '../types/account.type';
import { generateAvatar } from '../utils/generate-avatar';
import { CurrencyDollarIcon, PlusSmIcon } from '@heroicons/react/outline';
import { postType } from '../types/post.type';
import Post from '../components/post';
import { useEffect, useState } from 'react';
import { getProfileById } from '../api/get-profile-by-id';
import { useStore } from '../context/user.store';
import CreateNewCat from '../components/create-new-cat';
import PlaceholderCatIcon from '../assets/cat.png';
import { getPostsByAccount } from '../api/get-posts-by-account';

const Profile: React.FC = (props) => {
    const navigate = useNavigate();

    const { id } = useParams();
    const user = useStore((state) => state.user);

    const [profile, setProfile] = useState<AccountType | null>(null);
    const [posts, setPosts] = useState<postType[]>([]);

    useEffect(() => {
        async function getProfile() {
            const result = await getProfileById(id!);
            if (result === null) {
                // navigate(-1);
            } else {
                setProfile(result);
            }
        }
        getProfile();
    }, [id]);

    useEffect(() => {
        async function getPosts() {
            const result = await getPostsByAccount(id!);
            if (result === null) {
                // navigate(-1);
            } else {
                setPosts(result);
            }
        }
        getPosts();
    }, [id]);

    const avatar = generateAvatar(id!);
    const getLikes = () => {
        return posts ? posts.map((p) => p.likes).flat().length : 0;
    };

    const getPostsNumber = () => {
        return posts ? posts.length : 0;
    };
    console.log(profile);
    console.log(posts);
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
                    profile.cats.map((cat) => {
                        const catAvatar = cat.image ?? PlaceholderCatIcon;
                        return (
                            <Link
                                key={cat.id}
                                to={`/cat/${cat.id}`}
                                className="flex cursor-pointer flex-col items-center"
                            >
                                <img src={catAvatar} alt="cat" className="h-10 w-10 rounded-full" />
                                <p className="text-sm font-normal">{cat.name}</p>
                            </Link>
                        );
                    })
                ) : (
                    <p className="text-sm font-normal text-gray-500">No cats</p>
                )}
            </div>
            {user?.id == id && (
                <div className="-translate-y-14">
                    <CreateNewCat />
                </div>
            )}
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
                {posts.map((post) => {
                    return <Post key={post.id} post={post} displayComments={false} />;
                })}
            </div>
        </div>
    );
};

export default Profile;
