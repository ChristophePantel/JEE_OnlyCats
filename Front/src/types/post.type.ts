import { ProfileType } from './profile.type';

export type postType = {
    profile: ProfileType;
    post: {
        text?: string;
        image?: string;
        likes: likeType[];
        comment: commentType[];
    };
    id: string;
};

export type commentType = {
    profile: ProfileType;
    text: string;
    id: string;
};

export type likeType = {
    profileId: ProfileType['id'];
};
