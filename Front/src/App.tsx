import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './screens/Home';
import SignIn from './screens/Sign-in';
import SignUp from './screens/Sign-up';
import Profile from './screens/Profile';
import Post from './screens/Post';
import { useState } from 'react';
import Navbar from './components/navbar';
import Suggestions from './components/suggestions';
import Bookmarks from './screens/Bookmarks';
import Subscriptions from './screens/Subscriptions';

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(true);
    return (
        <>
            {!isLoggedIn && (
                <Routes>
                    <>
                        <Route path="/sign-in" element={<SignIn />} />
                        <Route path="/sign-up" element={<SignUp />} />
                    </>
                </Routes>
            )}
            {isLoggedIn && (
                <div className="flex min-h-screen flex-row">
                    <Navbar />
                    <div className="w-full">
                        <Routes>
                            <Route path="/subs" element={<Subscriptions />} />
                            <Route path="/bookmarks" element={<Bookmarks />} />
                            <Route path="/Profile/:id" element={<Profile />} />
                            <Route path="/Post/:id" element={<Post />} />
                            <Route path="/" element={<Home />} />
                        </Routes>
                    </div>
                    <Suggestions />
                </div>
            )}
        </>
    );
}

export default App;
