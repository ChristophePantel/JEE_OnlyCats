import { useState } from "react";
import { Link } from "react-router-dom";
import SignInHero from "../components/sign-in-hero";

export default function SignUp() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  function handleSubmit() {
    console.log(email, password);
  }
  return (
    <div className="flex flex-row w-screen h-screen">
      <SignInHero />
      <div className="flex flex-col w-1/2 items-center justify-center p-10">
        <div className="flex flex-col w-full gap-5 max-w-sm">
          <p className="font-bold text-4xl">Create your account</p>
          <input
            className="w-full rounded-lg py-3 px-5"
            type="email"
            placeholder="Name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <input
            className="w-full rounded-lg py-3 px-5"
            type="email"
            placeholder="email@example.com"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <input
            className="w-full rounded-lg py-3 px-5"
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button
            onClick={handleSubmit}
            className="bg-blue-400 rounded-full text-white font-semibold py-3 px-5"
          >
            Sign up
          </button>
          <Link
            to="/sign-in"
            className="border-blue-400 border py-3 px-5 rounded-full text-blue-400 font-semibold grid place-items-center"
          >
            Log in
          </Link>
          <p className="items-center text-xs text-center p-5 text-gray-400">
            By signing up you agree to our Terms of Service and Privacy Policy,
            and confirm that you are at least 18 years old.
          </p>
        </div>
      </div>
    </div>
  );
}
