import { PlusSmIcon, MinusSmIcon } from '@heroicons/react/outline';
import { Link } from 'react-router-dom';
import { useStore } from '../context/user.store';
import PlaceholderCatIcon from '../assets/cat.png';
import { deleteSubscription } from '../api/create-subscription';

export default function Subscriptions() {
    const userId = useStore((state) => state.user?.id);
    const subs = useStore((state) => state.user?.subs);
    const refetchUser = useStore((state) => state.refetch);

    const handleUnsubscribe = async (cat_id: number) => {
        await deleteSubscription(userId!, cat_id);
        await refetchUser();
    };

    return (
        <div className="flex flex-col gap-2 p-5">
            {(subs ?? []).map((sub) => (
                <div className="flex flex-row">
                    <Link
                        to={`/cat/${sub.cat.id}`}
                        className="flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold"
                    >
                        <img
                            alt="avatar"
                            src={sub.cat.image || PlaceholderCatIcon}
                            className="h-10 w-10 rounded-full object-cover"
                        />
                        <p>{sub.cat.name}</p>
                    </Link>
                    <button
                        onClick={() => handleUnsubscribe(sub.cat.id)}
                        className="ml-auto flex flex-row items-center gap-2 rounded-lg border-2 border-gray-400 px-2 text-sm font-bold text-gray-400"
                    >
                        <MinusSmIcon className="h-5 w-5" />
                        <p>Unsubscribe</p>
                    </button>
                </div>
            ))}
        </div>
    );
}
