import { useParams } from 'react-router-dom';
import { ProfileType } from '../types/profile.type';
import { generateAvatar } from '../utils/generate-avatar';
import { CurrencyDollarIcon, PlusSmIcon } from '@heroicons/react/outline';
import { postType } from '../types/post.type';
import Post from '../components/post';

const profile: ProfileType = {
    name: 'Heni Soula',
    id: '1',
};

const posts: postType[] = [
    {
        profile: {
            name: 'Heni Soula',
            id: '1',
        },
        post: {
            text: 'This is a post',
            image: 'https://picsum.photos/300/300',
            likes: [
                {
                    profileId: '1',
                },
                {
                    profileId: '2',
                },
            ],
            comment: [
                {
                    profile: {
                        name: 'Heni Soula',
                        id: '1',
                    },
                    text: 'hello from pakistan',
                    id: '1',
                },
                {
                    profile: {
                        name: 'Ghaith Oueslati',
                        id: '2',
                    },
                    text: 'hello from pakistan',
                    id: '2',
                },
            ],
        },
        id: '1',
    },
];

export default function Profile() {
    const { id } = useParams();
    const avatar = generateAvatar(id!);
    const getLikes = () => {
        return posts.reduce((acc, post) => {
            return acc + post.post.likes.length;
        }, 0);
    };

    return (
        <div className="flex w-full flex-col items-center gap-5">
            <div className="h-20 w-full bg-gray-200" />
            <img alt="avatar" src={avatar} className="h-20 w-20 -translate-y-14 rounded-full border" />
            <p className="-translate-y-14 font-semibold">{profile.name}</p>
            <div className="flex -translate-y-14 flex-row gap-4">
                <button className="flex flex-row items-center gap-2 rounded-lg bg-blue-400 py-2 px-4 font-bold text-white">
                    <PlusSmIcon className="h-5 w-5" />
                    <p>Subscribe</p>
                </button>
                <button className="flex flex-row items-center gap-2 rounded-lg border-2 border-blue-400 py-2 px-4 font-bold text-blue-400">
                    <CurrencyDollarIcon className="h-5 w-5" />
                    <p>Donate</p>
                </button>
            </div>
            <div className="flex -translate-y-14 flex-row gap-4">
                <div className="flex flex-col items-center">
                    <p className="text-xs">Posts</p>
                    <p className="font-bold">{posts.length}</p>
                </div>
                <div className="flex flex-col items-center">
                    <p className="text-xs">Likes</p>
                    <p className="font-bold">{getLikes()}</p>
                </div>
            </div>
            <hr className="w-full -translate-y-14" />
            <div className="flex -translate-y-14 flex-col">
                {posts.map((post) => (
                    <Post key={post.id} data={post} displayComments={false} />
                ))}
            </div>
        </div>
    );
}
