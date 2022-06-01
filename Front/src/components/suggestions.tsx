import SearchBar from './search-bar';
import { LogoutIcon } from '@heroicons/react/outline';
import { useStore } from '../context/user.store';

export default function Suggestions() {
    const logout = useStore((state) => state.logout);
    return (
        <div className="sticky top-0 right-0 flex h-screen w-3/4 flex-col gap-5 border border-l-gray-200 bg-white py-8 px-10">
            <SearchBar />
            <div className="ml-auto mt-auto">
                <button className="flex flex-row items-center gap-2 rounded border p-2 text-gray-400" onClick={logout}>
                    <LogoutIcon className="h-5 w-5" />
                    <p>Sign out</p>
                </button>
            </div>
        </div>
    );
}
