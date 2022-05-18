import { SearchIcon } from '@heroicons/react/outline';
import { Combobox } from '@headlessui/react';

const SearchBar: React.FC = () => {
  return (
    <Combobox value="" onChange={() => {}} as="div" className="w-2/3 rounded-lg border border-gray-300">
      <div className="flex flex-row items-center gap-3 px-4 py-1">
        <Combobox.Input
          placeholder="Search Posts"
          onChange={() => {}}
          className="w-full border-none px-0 text-sm placeholder:text-gray-400 focus:outline-none focus:ring-0"
        />
        <SearchIcon className="h-5 w-5 text-gray-400" />
      </div>
      <Combobox.Options className="flex flex-col gap-1">
        <Combobox.Option value="Post 1" className="cursor-pointer px-3 py-2 hover:bg-gray-100">
          Post 1
        </Combobox.Option>
        <Combobox.Option value="Post 2" className="cursor-pointer px-3 py-2 hover:bg-gray-100">
          Post 2
        </Combobox.Option>
        <Combobox.Option value="Post 3" className="cursor-pointer px-3 py-2 hover:bg-gray-100">
          Post 3{' '}
        </Combobox.Option>
      </Combobox.Options>
    </Combobox>
  );
};

export default SearchBar;
