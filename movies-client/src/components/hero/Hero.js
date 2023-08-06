import React from 'react'

import Carousel from 'react-material-ui-carousel'
import { Paper } from '@mui/material'

import './Hero.css'

const Hero = ({ moviesArr = [] }) => {

    return (
        <div className='movie-carousel-container'>
            <Carousel>
                {
                    moviesArr.map(m =>
                        <Paper key={m.imdb} >
                            <div className='movie-card-container'>
                                <div className='movie-card' style={{"--img": `url(${m.backdrops[0]})`}}>
                                    <div className='movie-detail'>
                                        <div className='movie-poster'>
                                            <img src={m.poster} alt='' />
                                        </div>
                                        <div className='movie-title'>
                                            <h4>{m.title}</h4>
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