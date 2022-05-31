export default function SignInHero() {
    return (
        <div className="relative flex w-1/2 flex-col items-center justify-center bg-blue-400">
            <div className="z-10 flex flex-col gap-3">
                <h1 className="text-5xl font-bold text-white">OnlyCats</h1>
                <p className="text-3xl text-white">Sign up to support your favorite cat!</p>
            </div>
            <img
                className="absolute h-full w-full object-cover brightness-75"
                src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/close-up-of-cat-wearing-sunglasses-while-sitting-royalty-free-image-1571755145.jpg?crop=0.670xw:1.00xh;0.147xw,0&resize=980:*"
                alt="cat"
            />
        </div>
    );
}
