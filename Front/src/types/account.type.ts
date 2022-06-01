import { BookmarkType } from './bookmark.type';
import { CatType } from './cat.type';
import { SubscriptionType } from './subscription.type';

export type AccountType = {
    id: number;
    username: string;
    email?: string;
    password?: string;
    cats?: CatType[];
    subs?: SubscriptionType[];
    bookmarks?: BookmarkType[];
};
