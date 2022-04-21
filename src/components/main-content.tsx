import CreateNewPost from './create-new-post';
import Post from './post';
import { LightningBoltIcon } from '@heroicons/react/outline';

type postType = {
  profile: {
    name: string;
    avatar: string;
  };
  post: {
    text?: string;
    image: string;
    likes: number;
  };
  id: string;
};
const testPosts: postType[] = [
  {
    profile: {
      avatar: 'https://picsum.photos/200/300',
      name: 'Heni Soula',
    },
    post: {
      text: 'This is a post',
      image: 'https://picsum.photos/300/300',
      likes: 10,
    },
    id: '1',
  },
  {
    profile: {
      avatar: 'https://picsum.photos/400/300',
      name: 'Ghaith Oueslati',
    },
    post: {
      text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
      image: 'https://picsum.photos/500/300',
      likes: 20,
    },
    id: '2',
  },
];

export default function MainContent() {
  return (
    <div className="w-full">
      <h1 className="border-b border-b-gray-300 p-3 text-2xl font-semibold">Home</h1>
      <CreateNewPost />
      <div className="flex flex-col">
        {testPosts.map((post) => (
          <Post key={post.id} post={post.post} profile={post.profile} />
        ))}
        <div className="grid w-full place-items-center py-5">
          <LightningBoltIcon className="h-7 w-7 animate-bounce text-gray-300" />
        </div>
      </div>
    </div>
  );
}
