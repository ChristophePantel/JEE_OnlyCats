import { PlusSmIcon, MinusSmIcon } from '@heroicons/react/outline';
import { Link } from 'react-router-dom';
import { AccountType } from '../types/account.type';
import { generateAvatar } from '../utils/generate-avatar';

const subscriptions: AccountType['subsciptions'] = [
    {
        id: 1,
        id_profile: 1,
        name: 'test cat',
        image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        subscribers: [],
    },
    {
        id: 2,
        id_profile: 2,
        name: 'test cat',
        image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        subscribers: [],
    },
];

export default function Subscriptions() {
    console.log(subscriptions);
    return (
        <div className="flex flex-col gap-2 p-5">
            {(subscriptions ?? []).map((cat) => (
                <div className="flex flex-row">
                    <Link
                        to={`/Profile/${cat.id}`}
                        className="flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold"
                    >
                        <img alt="avatar" src={cat.image} className="h-10 w-10 rounded-full object-cover" />
                        <p>{cat.name}</p>
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
            ))}
        </div>
    );
}
