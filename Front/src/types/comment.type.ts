import { AccountType } from "./account.type";

export type CommentType = {
    id: number;
    id_post: number;
    account: AccountType;
    text: string;
}