import { AccountType } from './account.type';
import { postType } from './post.type';

export type BookmarkType = {
    id: number;
    post: postType;
    account: AccountType;
};
