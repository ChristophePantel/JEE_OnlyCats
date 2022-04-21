import { Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './screens/Home';
import SignIn from './screens/Sign-in';
import SignUp from './screens/Sign-up';
import Profile from './screens/Profile';

function App() {
  return (
    <Routes>
      <Route path="/sign-in" element={<SignIn />} />
      <Route path="/sign-up" element={<SignUp />} />
      <Route path="/Profile/:id" element={<Profile />} />
      <Route path="/" element={<Home />} />
    </Routes>
  );
}

export default App;
