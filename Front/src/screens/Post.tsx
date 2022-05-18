import { useParams } from 'react-router-dom';
import Post from '../components/post';
import { postType } from '../types/post.type';

const data: postType = {
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
};

export default function PostPage() {
    const { id } = useParams();
    // todo: get post from server using id
    return <Post data={data} displayComments={true} />;
}
