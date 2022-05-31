import { PhotographIcon } from '@heroicons/react/outline';
import { useId, useState } from 'react';
import { createPost } from '../api/create-post';
import { useStore } from '../context/user.store';
import { AccountType } from '../types/account.type';

const CreateNewPost: React.FC = (props) => {
    const fileInputId = useId();
    const user = useStore((state) => state.user);

    const [text, setText] = useState('');
    const [image, setImage] = useState<File | undefined>(undefined);

    async function handleSubmit() {
        console.log({ text, image });
        if (!text && !image) {
            return;
        } else {
            console.log('creating post');
            await createPost(user!.id, 1, text, image);
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
