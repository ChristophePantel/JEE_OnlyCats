import { AccountType } from "./account.type";
import { CatType } from "./cat.type";
import { CommentType } from "./comment.type";
import { LikeType } from "./like.type";

export type postType = {
    id: number;
    cat: {
        id: CatType["id"]
        name: CatType["name"],
        image: CatType["image"]
    };
    user: {
        username: AccountType["username"],
        id: AccountType["id"]
    }
    text: string;
    image?: string;
    comments: CommentType[]
    likes: LikeType[]
    bookmarkers: AccountType[]
}