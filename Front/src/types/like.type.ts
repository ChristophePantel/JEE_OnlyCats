import { AccountType } from './account.type';
import { postType } from './post.type';

export type LikeType = {
    id: number;
    post: postType;
    account: AccountType;
};
