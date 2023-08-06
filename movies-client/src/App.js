import './App.css';
import { useEffect, useState } from 'react';
import axiosInstance from './util/api/apiService';

function App() {
    const [movies, setMovies] = useState();

    const getMovies = async () => {
        try {
            const data = await axiosInstance.get('api/v1/movies')
            console.log(data);
            setMovies(data);
        } catch (err) {
            console.error(err);
        }
    }

    useEffect(() => {
        getMovies();
    }, [])

    return (
        <div className="App">
        </div>
    );
}

export default App;
