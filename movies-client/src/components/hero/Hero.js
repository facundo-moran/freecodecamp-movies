import React from 'react'

import Carousel from 'react-material-ui-carousel'
import { Link, useNavigate } from 'react-router-dom'
import { Paper } from '@mui/material'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCirclePlay } from '@fortawesome/free-solid-svg-icons'

import './Hero.css'
import { Button } from 'react-bootstrap'

const Hero = ({ moviesArr = [] }) => {

    const navigate = useNavigate();

    const reviews = (movieId) => {
        navigate(`/reviews/${movieId}`)
    }

    return (
        <div className='movie-carousel-container'>
            <Carousel>
                {
                    moviesArr.map(m =>
                        <Paper key={m.imdb} >
                            <div className='movie-card-container'>
                                <div className='movie-card' style={{ "--img": `url(${m.backdrops[0]})` }}>
                                    <div className='movie-detail'>
                                        <div className='movie-poster'>
                                            <img src={m.poster} alt='' />
                                        </div>
                                        <div className='movie-title'>
                                            <h4>{m.title}</h4>
                                        </div>
                                        <div className='movie-btn-container'>
                                            <Link to={`/trailer/${m.trailerLink.substring(m.trailerLink.length - 11)}`}>
                                                <div className='movie-play-btn-container'>
                                                    <FontAwesomeIcon className='movie-play-btn' icon={faCirclePlay} />
                                                </div>
                                            </Link>
                                            <div className='movie-review-button-container'>
                                                <Button variant='info' onClick={() => reviews(m.imdb)}>
                                                    Reviews
                                                </Button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </Paper>)
                }
            </Carousel>
        </div>
    )
}

export default Hero