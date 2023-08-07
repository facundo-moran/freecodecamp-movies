import { useEffect, useState } from 'react';
import { Route, Routes } from 'react-router-dom';

import Layout from './components/Layout';
import Home from './components/home/Home'
import Header from './components/header/Header';
import axiosInstance from './util/api/apiService';

import './App.css';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';
import NotFound from './components/notFound/NotFound';

function App() {
    const [movies, setMovies] = useState([]);
    const [reviews, setReviews] = useState([]);
    const [movie, setMovie] = useState(null);

    const getMovies = async () => {
        try {
            const data = await axiosInstance.get('api/v1/movies')
            console.log(data);
            setMovies(data);
        } catch (err) {
            console.error(err);
        }
    }

    const getMovieData = async (movieId) => {
        try {
            const data = await axiosInstance.get(`api/v1/movies/${movieId}`)
            console.log(data);
            setMovie(data);
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
                    <Route path="/" element={<Home moviesArr={movies} />} />
                    <Route path="/trailer/:ytTrailerId" element={<Trailer />} />
                    <Route path="/reviews/:movieId"
                        element={
                            <Reviews
                                getMovieData={getMovieData}
                                movie={movie}
                                reviews={reviews}
                                setReviews={setReviews}
                            />
                        }
                    />
                    <Route path="*" element={<NotFound />}></Route>
                </Route>
            </Routes>
        </div>
    );
}

export default App;
