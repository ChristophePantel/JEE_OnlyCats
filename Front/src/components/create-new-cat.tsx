import { useModal } from '../context/modal.store';
import { PhotographIcon, XIcon } from '@heroicons/react/outline';
import { CatType } from '../types/cat.type';
import { useId, useState } from 'react';
import { createCat } from '../api/create-cat';
import { useStore } from '../context/user.store';
import { useNavigate } from 'react-router-dom';

type Props = {};

const CreateNewCat = (props: Props) => {
    const fileInputId = useId();
    const navigate = useNavigate();

    const ownerId = useStore((state) => state.user?.id);
    const refetchUser = useStore((state) => state.refetch);

    const setModal = useModal((state) => state.setModal);
    const clearModal = useModal((state) => state.clearModal);

    const Modal = () => {
        const [name, setName] = useState('');
        const [image, setImage] = useState<File | undefined>(undefined);

        const handleSubmit = async () => {
            const cat = await createCat(name, ownerId!, image);
            if (cat) {
                clearModal();
                await refetchUser();
                navigate(`/cat/${cat.id}`);
            }
        };
        return (
            <div className="flex w-96 flex-col gap-4 rounded-lg bg-white p-5">
                <div className="flex flex-row items-center">
                    <h1 className="text-lg font-bold">Create new cat</h1>
                    <XIcon onClick={clearModal} className="ml-auto h-5 w-5 cursor-pointer" />
                </div>
                <input
                    placeholder="Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    className="w-full rounded-lg border py-3 px-5"
                />
                <div className="grid place-items-center rounded-lg border p-2 text-gray-400">
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
                    Create
                </button>
            </div>
        );
    };

    return (
        <>
            <button
                onClick={() => setModal(<Modal />)}
                className="rounded border p-2 text-sm text-gray-500 duration-200 hover:bg-gray-100"
            >
                New cat
            </button>
        </>
    );
};

export default CreateNewCat;
