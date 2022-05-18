import MainContent from '../components/main-content';
import { postType } from '../types/post.type';

const testPosts: postType[] = [
    {
        profile: {
            name: 'Heni Soula',
            id: '1',
        },
        post: {
            text: 'This is a post',
            image: 'https://picsum.photos/300/300',
            likes: [
                {
                    profileId: '1',
                },
            ],
            comment: [
                {
                    profile: {
                        name: 'Heni Soula',
                        id: '1',
                    },
                    text: 'hello from pakistan',
                    id: '1',
                },
                {
                    profile: {
                        name: 'Ghaith Oueslati',
                        id: '2',
                    },
                    text: 'hello from pakistan',
                    id: '2',
                },
            ],
        },
        id: '1',
    },
    {
        profile: {
            name: 'Ghaith Oueslati',
            id: '2',
        },
        post: {
            text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
            image: 'https://picsum.photos/500/300',
            likes: [
                {
                    profileId: '2',
                },
            ],
            comment: [],
        },
        id: '2',
    },
];

export default function Home() {
    return <MainContent posts={testPosts} />;
}
