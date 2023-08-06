import React from 'react'
import Hero from '../hero/Hero'

const Home = ({moviesArr=[]}) => {
  return (
    <Hero moviesArr={moviesArr} />
  )
}

export default Home