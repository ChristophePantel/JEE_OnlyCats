import { ChevronDownIcon, PhotographIcon } from '@heroicons/react/outline';
import { useId, useState } from 'react';
import { createPost } from '../api/create-post';
import { useStore } from '../context/user.store';
import { useNavigate } from 'react-router-dom';

const CreateNewPost: React.FC = (props) => {
    const fileInputId = useId();
    const user = useStore((state) => state.user);
    const navigate = useNavigate();

    const [text, setText] = useState('');
    const [image, setImage] = useState<File | undefined>(undefined);
    const [catId, setCatId] = useState(user?.cats?.[0]?.id || null);

    const [selectionOpen, setSelectionOpen] = useState(false);

    async function handleSubmit() {
        if (!catId) return;
        if (!text && !image) {
            return;
        } else {
            const result = await createPost(user!.id, catId, text, image);
            if (result) {
                navigate(`/post/${result.id}`);
            }
        }
    }

    return (
        <div className="flex w-full flex-col border-b border-b-gray-300">
            <textarea
                placeholder="Create a new post..."
                className="resize-none border-none p-5 outline-none placeholder:text-gray-400 focus:ring-0"
                rows={3}
                value={text}
                onChange={(e) => setText(e.target.value)}
            />
            <div className="flex flex-row items-center py-2 px-5">
                <div className="flex flex-row text-gray-400">
                    <label htmlFor={fileInputId} className="h-5 w-5 cursor-pointer hover:text-black">
                        <PhotographIcon />
                    </label>
                    <input
                        type="file"
                        hidden
                        id={fileInputId}
                        onChange={(e) => setImage(e.target.files?.[0])}
                        accept="image/*"
                    />
                </div>
                <div className="ml-auto">
                    {!user?.cats || user?.cats?.length === 0 ? (
                        <p className="text-xs text-gray-400">Create a cat before posting</p>
                    ) : (
                        <div className="relative">
                            <div
                                onClick={() => setSelectionOpen(!selectionOpen)}
                                className="flex cursor-pointer flex-row items-center gap-1"
                            >
                                <div className="text-sm font-bold">{user?.cats?.find((c) => c.id == catId)?.name}</div>
                                <ChevronDownIcon className="h-4 w-4" />
                            </div>
                            {selectionOpen && (
                                <div className="absolute top-full left-0 z-50 w-20 rounded border bg-white py-4">
                                    {user?.cats?.map((cat) => (
                                        <p
                                            onClick={() => {
                                                setCatId(cat.id);
                                                setSelectionOpen(false);
                                            }}
                                            className={`cursor-pointer p-2 hover:bg-gray-100 ${
                                                cat.id === catId ? 'bg-gray-200' : 'bg-white'
                                            }`}
                                        >
                                            {cat.name}
                                        </p>
                                    ))}
                                </div>
                            )}
                        </div>
                    )}
                </div>
                <button
                    onClick={handleSubmit}
                    className="ml-auto rounded-full bg-blue-400 py-2 px-5 font-semibold text-white"
                >
                    Post
                </button>
            </div>
        </div>
    );
};

export default CreateNewPost;
