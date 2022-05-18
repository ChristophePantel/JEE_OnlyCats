import React from 'react';
import SearchBar from './search-bar';

export default function Suggestions() {
  return (
    <div className="sticky top-0 right-0 flex h-screen w-3/4 flex-col gap-5 border border-l-gray-200 bg-white py-8 px-10">
      <SearchBar />
    </div>
  );
}
