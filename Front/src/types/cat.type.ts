import { AccountType } from './account.type';
import { postType } from './post.type';

export type CatType = {
    id: number;
    id_profile: number;
    name: string;
    image: string;
    posts: postType[];
    subscribers: AccountType[];
};
