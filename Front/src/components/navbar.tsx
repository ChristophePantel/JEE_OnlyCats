import { Link, NavLink } from 'react-router-dom';
import { HomeIcon, BookmarkIcon, UserIcon } from '@heroicons/react/outline';
import {
    HomeIcon as HomeIconFilled,
    BookmarkIcon as BookmarkIconFilled,
    UserIcon as UserIconFilled,
} from '@heroicons/react/solid';
import { createAvatar } from '@dicebear/avatars';
import React from 'react';
import { AccountType } from '../types/account.type';
import { generateAvatar } from '../utils/generate-avatar';

type Props = {
    profile: AccountType;
};

const Navbar: React.FC<Props> = (props) => {
    return (
        <div className="sticky top-0 left-0 flex h-screen w-3/4 flex-col items-end gap-5 border border-l-gray-200 bg-white py-8 px-10">
            <ProfileContainer profile={props.profile} />
            <NavBarLink to="/" name="Home" icon={<HomeIcon />} activeIcon={<HomeIconFilled />} />
            <NavBarLink to="/bookmarks" name="Bookmarks" icon={<BookmarkIcon />} activeIcon={<BookmarkIconFilled />} />
            <NavBarLink to="/subs" name="Subscriptions" icon={<UserIcon />} activeIcon={<UserIconFilled />} />
        </div>
    );
};

export default Navbar;

type NavBarLinkProps = {
    name: string;
    to: string;
    icon: React.ReactNode;
    activeIcon: React.ReactChild;
};
const NavBarLink: React.FC<NavBarLinkProps> = (props) => {
    return (
        <NavLink
            to={props.to}
            className={({ isActive }) =>
                `flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold ${
                    isActive ? 'text-gray-800' : 'text-gray-400 hover:bg-blue-50 hover:text-blue-500'
                }`
            }
        >
            {({ isActive }) => (
                <>
                    <div className="h-8 w-8">{isActive ? props.activeIcon : props.icon}</div>
                    <p>{props.name}</p>
                </>
            )}
        </NavLink>
    );
};

type ProfileContainerProps = {
    profile: AccountType;
};
const ProfileContainer: React.FC<ProfileContainerProps> = (props) => {
    const avatar = generateAvatar(props.profile.id);
    return (
        <Link
            to={`/Profile/${props.profile.id}`}
            className="flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold"
        >
            <img alt="avatar" src={avatar} className="h-10 w-10 rounded-full" />
            <p>{props.profile.username}</p>
        </Link>
    );
};
