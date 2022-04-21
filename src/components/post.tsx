import { HeartIcon, BookmarkIcon } from '@heroicons/react/outline';
import { HeartIcon as HeartIconFilled, BookmarkIcon as BookmarkIconFIlled } from '@heroicons/react/solid';

type Props = {
  profile: {
    name: string;
    avatar: string;
  };
  post: {
    text?: string;
    image?: string;
    likes: number;
  };
};

const Post: React.FC<Props> = (props) => {
  return (
    <div className="flex w-full flex-col border-b border-b-gray-300">
      <div className="flex flex-row items-center gap-3 py-3 px-4">
        <img src={props.profile.avatar} alt="avatar" className="h-12 w-12 rounded-full" />
        <p className="font-semibold text-gray-900">{props.profile.name}</p>
      </div>
      {props.post.text && <p className="px-4 py-2">{props.post.text}</p>}
      {props.post.image && <img src={props.post.image} alt="post" className="aspect-video h-80 object-cover" />}
      <div className="flex flex-row items-center py-3 px-4">
        <div className="flex flex-row items-center gap-3">
          <HeartIcon className="h-6 w-6 cursor-pointer text-gray-300 hover:text-black" />
          <p className="text-sm text-gray-400">{props.post.likes}</p>
        </div>
        <BookmarkIcon className="ml-auto h-6 w-6 cursor-pointer text-gray-300 hover:text-black" />
      </div>
    </div>
  );
};

export default Post;
