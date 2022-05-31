import { useParams } from 'react-router-dom';
import Post from '../components/post';
import { postType } from '../types/post.type';

const data: postType = {
    id: 1,
    cat: {
        id: 1,
        image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
        name: 'test cat',
    },
    image: 'https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60',
    user: {
        id: 1,
        username: 'test',
    },
    text: 'hello from pakistan',
    comments: [
        {
            id: 1,
            account: {
                id: 1,
                username: 'test',
            },
            id_post: 1,
            text: 'hello from pakistan',
        },
        {
            id: 2,
            account: {
                id: 1,
                username: 'test',
            },
            id_post: 1,
            text: 'hello from pakistan',
        },
    ],
    likes: [],
    bookmarkers: [],
};

export default function PostPage() {
    const { id } = useParams();
    // todo: get post from server using id
    return <Post post={data} displayComments={true} />;
}
