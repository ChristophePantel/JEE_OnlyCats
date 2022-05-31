import { CatType } from "./cat.type";
import { postType } from "./post.type";

export type AccountType = {
    id: number;
    username: string;
    email?: string;
    password?: string;
    cats?: CatType[];
    subsciptions?: CatType[];
    bookmarks?: postType[]
}