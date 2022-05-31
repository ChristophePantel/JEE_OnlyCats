import MainContent from '../components/main-content';
import { postType } from '../types/post.type';

const testPosts: postType[] = [
    {
        id: 1,
        cat: {
            id: 1,
            name: 'test cat',
            image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        },
        image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        user: {
            id: 1,
            username: 'test',
        },
        text: 'hello from pakistan',
        comments: [],
        likes: [],
        bookmarkers: [],
    },
];

export default function Home() {
    return <MainContent posts={testPosts} />;
}
