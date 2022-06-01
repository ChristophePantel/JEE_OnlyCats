import { SearchIcon } from '@heroicons/react/outline';
import { Combobox } from '@headlessui/react';
import { useEffect, useState } from 'react';
import useDebounce from '../hooks/useDebounce';
import { CatType } from '../types/cat.type';
import { searchCatByName } from '../api/search-cat-by-name';
import PlaceholderCatIcon from '../assets/cat.png';
import { Link } from 'react-router-dom';

const SearchBar: React.FC = () => {
    const [value, setValue] = useState('');
    const debouncedValue = useDebounce(value, 500);
    const [results, setResults] = useState<CatType[]>([]);

    useEffect(() => {
        async function search() {
            const results = await searchCatByName(debouncedValue);
            setResults(results || []);
        }

        search();
    }, [debouncedValue]);
    return (
        <Combobox value="" onChange={() => {}} as="div" className="w-2/3 rounded-lg border border-gray-300">
            <div className="flex flex-row items-center gap-3 px-4 py-1">
                <Combobox.Input
                    placeholder="Search Posts"
                    onChange={(e) => setValue(e.target.value)}
                    value={value}
                    className="w-full border-none px-0 text-sm placeholder:text-gray-400 focus:outline-none focus:ring-0"
                />
                <SearchIcon className="h-5 w-5 text-gray-400" />
            </div>
            <Combobox.Options className="flex flex-col gap-1">
                {results.map((result) => (
                    <Combobox.Option value={result.id}>
                        <Link
                            to={`/cat/${result.id}`}
                            className="flex w-full flex-row items-center gap-2 p-2 px-3 py-2 hover:bg-gray-100"
                        >
                            <img
                                src={result.image ?? PlaceholderCatIcon}
                                alt="cat"
                                className="h-12 w-12 rounded-full object-cover"
                            />
                            <p className="font-semibold text-gray-900">{result.name}</p>
                        </Link>
                    </Combobox.Option>
                ))}
            </Combobox.Options>
        </Combobox>
    );
};

export default SearchBar;
