import { PlusSmIcon, MinusSmIcon } from '@heroicons/react/outline';
import { Link } from 'react-router-dom';
import { ProfileType } from '../types/profile.type';
import { generateAvatar } from '../utils/generate-avatar';

const profiles: ProfileType[] = [
    {
        name: 'Heni Soula',
        id: '1',
    },
    {
        name: 'Ghaith Oueslati',
        id: '2',
    },
];

export default function Subscriptions() {
    return (
        <div className="flex flex-col gap-2 p-5">
            {profiles.map((profile) => {
                const avatar = generateAvatar(profile.id);
                return (
                    <div className="flex flex-row">
                        <Link
                            to={`/Profile/${profile.id}`}
                            className="flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold"
                        >
                            <img alt="avatar" src={avatar} className="h-10 w-10 rounded-full" />
                            <p>{profile.name}</p>
                        </Link>
                        {/* <button className="flex flex-row items-center gap-2 rounded-lg bg-blue-400 py-2 px-4 text-sm font-bold text-white">
                            <PlusSmIcon className="h-5 w-5" />
                            <p>Subscribe</p>
                        </button> */}
                        <button className="ml-auto flex flex-row items-center gap-2 rounded-lg border-2 border-gray-400 px-2 text-sm font-bold text-gray-400">
                            <MinusSmIcon className="h-5 w-5" />
                            <p>Unsubscribe</p>
                        </button>
                    </div>
                );
            })}
        </div>
    );
}
