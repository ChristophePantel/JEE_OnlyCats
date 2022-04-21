import { PhotographIcon } from '@heroicons/react/outline';
import { useId } from 'react';

const CreateNewPost: React.FC = () => {
  const fileInputId = useId();
  return (
    <div className="flex w-full flex-col border-b border-b-gray-300">
      <textarea
        placeholder="Create a new post..."
        className="resize-none border-none p-5 outline-none placeholder:text-gray-400 focus:ring-0"
        rows={3}
      />
      <div className="flex flex-row items-center py-2 px-5">
        <div className="flex flex-row text-gray-400">
          <label htmlFor={fileInputId} className="h-5 w-5 cursor-pointer hover:text-black">
            <PhotographIcon />
          </label>
          <input type="file" hidden id={fileInputId} />
        </div>
        <button className="ml-auto rounded-full bg-blue-400 py-2 px-5 font-semibold text-white">Post</button>
      </div>
    </div>
  );
};

export default CreateNewPost;
