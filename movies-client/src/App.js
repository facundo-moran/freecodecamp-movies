import { useEffect, useState } from 'react';
import { Route, Routes } from 'react-router-dom';

import Layout from './components/Layout';
import Home from './components/home/Home'
import Header from './components/header/Header';
import axiosInstance from './util/api/apiService';

import './App.css';

function App() {
    const [movies, setMovies] = useState();

    const getMovies = async () => {
        try {
            const data = await axiosInstance.get('api/v1/movies')
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
            <Header />
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route path="/" element={<Home moviesArr={movies} />}>
                    </Route>
                </Route>
            </Routes> 
        </div>
    );
}

export default App;
