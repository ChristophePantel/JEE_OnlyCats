import { Link, NavLink } from 'react-router-dom';
import { HomeIcon, BookmarkIcon, UserIcon } from '@heroicons/react/outline';
import {
  HomeIcon as HomeIconFilled,
  BookOpenIcon as BookOpenIconFilled,
  UserIcon as UserIconFilled,
} from '@heroicons/react/solid';
import { createAvatar } from '@dicebear/avatars';
import * as style from '@dicebear/open-peeps';
import React from 'react';

export default function Navbar() {
  return (
    <div className="sticky top-0 left-0 flex h-screen w-3/4 flex-col items-end gap-5 border border-l-gray-200 bg-white py-8 px-10">
      <ProfileContainer name="Heni Soula" status={true} />
      <NavBarLink to="/" name="Home" icon={<HomeIcon />} activeIcon={<HomeIconFilled />} />
      <NavBarLink to="/bookmarks" name="Bookmarks" icon={<BookmarkIcon />} activeIcon={<BookOpenIconFilled />} />
      <NavBarLink to="/subs" name="Subscriptions" icon={<UserIcon />} activeIcon={<UserIconFilled />} />
    </div>
  );
}

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
  name: string;
  status: boolean;
};
const ProfileContainer: React.FC<ProfileContainerProps> = (props) => {
  let avatar = createAvatar(style, {
    seed: props.name,
    dataUri: true,
  });
  return (
    <Link
      to={`/Profile/${props.name}`}
      className="flex w-2/3 flex-row items-center gap-5 rounded-lg py-2 px-2 font-semibold"
    >
      <img alt="avatar" src={avatar} className="h-10 w-10 rounded-full" />
      <p>{props.name}</p>
      <div className={`h-2 w-2 rounded-full ${props.status ? 'bg-green-700' : 'bg-gray-500'}`} />
    </Link>
  );
};
