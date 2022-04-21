export default function SignInHero() {
  return (
    <div className="bg-blue-400 flex flex-col w-1/2 items-center justify-center relative">
      <div className="z-10 flex flex-col gap-3">
        <h1 className="font-bold text-5xl text-white">OnlyCats</h1>
        <p className="text-3xl text-white">
          Sign up to support your favorite cat!
        </p>
      </div>
      <img
        className="absolute w-full h-full brightness-75"
        src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/close-up-of-cat-wearing-sunglasses-while-sitting-royalty-free-image-1571755145.jpg?crop=0.670xw:1.00xh;0.147xw,0&resize=980:*"
        alt="cat"
      />
    </div>
  );
}
