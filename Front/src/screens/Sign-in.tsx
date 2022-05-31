import { useState } from 'react';
import { Link } from 'react-router-dom';
import SignInHero from '../components/sign-in-hero';
import { useStore } from '../context/user.store';
import { verifyEmail } from '../utils/verify-email';

type Hints = {
    email?: string;
    password?: string;
};

export default function SignIn() {
    const login = useStore((state) => state.login);

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [hints, setHints] = useState<Hints>({});

    async function handleSubmit() {
        let newHints = { ...hints };
        if (!email || !verifyEmail(email)) {
            newHints = { ...newHints, email: 'Email is required and must be valid.' };
        } else {
            newHints = { ...newHints, email: undefined };
        }
        if (!password) {
            newHints = { ...newHints, password: 'Password is required.' };
        } else {
            newHints = { ...newHints, password: undefined };
        }
        setHints(newHints);

        if (!newHints.email && verifyEmail(email) && !newHints.password) {
            await login({ email, password });
        }
    }
    return (
        <div className="flex h-screen w-screen flex-row">
            <SignInHero />
            <div className="flex w-1/2 flex-col items-center justify-center p-10">
                <div className="flex w-full max-w-sm flex-col gap-5">
                    <p className="text-4xl font-bold">Log in</p>
                    <div className="flex w-full flex-col justify-center gap-1">
                        <input
                            className={`w-full rounded-lg py-3 px-5 ${hints.email ? 'border-red-500' : ''}`}
                            type="text"
                            placeholder="Email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                        <p className="text-xs text-red-500">{hints.email}</p>
                    </div>
                    <div className="flex w-full flex-col justify-center gap-1">
                        <input
                            className={`w-full rounded-lg py-3 px-5 ${hints.password ? 'border-red-500' : ''}`}
                            type="password"
                            placeholder="Password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                        <p className="text-xs text-red-500">{hints.password}</p>
                    </div>
                    <button
                        onClick={handleSubmit}
                        className="rounded-full bg-blue-400 py-3 px-5 font-semibold text-white"
                    >
                        Log in
                    </button>
                    <Link
                        to="/sign-up"
                        className="grid place-items-center rounded-full border border-blue-400 py-3 px-5 font-semibold text-blue-400"
                    >
                        Sign up
                    </Link>
                </div>
            </div>
        </div>
    );
}
