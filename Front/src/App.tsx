import './App.css';
import { Route, Routes } from 'react-router-dom';
import Home from './screens/Home';
import SignIn from './screens/Sign-in';
import SignUp from './screens/Sign-up';
import Profile from './screens/Profile';
import Post from './screens/Post';
import Navbar from './components/navbar';
import Suggestions from './components/suggestions';
import Bookmarks from './screens/Bookmarks';
import Subscriptions from './screens/Subscriptions';
import { useStore } from './context/user.store';
import Modal from './components/modal';
import Cat from './screens/Cat';

function App() {
    const user = useStore((state) => state.user);
    return (
        <>
            {!user ? (
                <Routes>
                    <>
                        <Route path="/*" element={<SignIn />} />
                        <Route path="/sign-up" element={<SignUp />} />
                    </>
                </Routes>
            ) : (
                <>
                    <Modal />
                    <div className="flex min-h-screen flex-row">
                        <Navbar profile={user} />
                        <div className="w-full">
                            <Routes>
                                <Route path="/Profile/:id" element={<Profile />} />
                                <Route path="/Cat/:id" element={<Cat />} />
                                <Route path="/Post/:id" element={<Post />} />
                                <Route path="/subs" element={<Subscriptions />} />
                                <Route path="/bookmarks" element={<Bookmarks />} />
                                <Route path="/*" element={<Home />} />
                            </Routes>
                        </div>
                        <Suggestions />
                    </div>
                </>
            )}
        </>
    );
}

export default App;
