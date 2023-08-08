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
            setMovies(data);
        } catch (err) {
            console.error(err);
        }
    }

    const getMovieData = async (movieId) => {
        try {
            const data = await axiosInstance.get(`api/v1/movies/${movieId}`)
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
                <Route path="/freecodecamp-movies" element={<Layout />}>
                    <Route path="/freecodecamp-movies/" element={<Home moviesArr={movies} />} />
                    <Route path="/freecodecamp-movies/trailer/:ytTrailerId" element={<Trailer />} />
                    <Route path="/freecodecamp-movies/reviews/:movieId"
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
