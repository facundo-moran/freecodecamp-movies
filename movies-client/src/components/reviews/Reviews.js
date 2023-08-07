import React, { useEffect, useRef } from 'react'
import axiosInstance from '../../util/api/apiService'
import { useParams } from 'react-router-dom'
import { Col, Container, Row } from 'react-bootstrap'
import ReviewForm from '../reviewForm/ReviewForm'


const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {
    const revText = useRef();
    const params = useParams();
    const movieId = params.movieId;

    useEffect(() => {
        getMovieData(movieId);
    }, [])

    const addReview = async (e) => {
        e.preventDefault()

        const rev = revText.current;

        try {

            await axiosInstance.post('/api/v1/reviews', { body: rev.value, imdb: movieId })
            const updatedReviews = [...reviews, { body: rev.value }]

            rev.value = "";
            setReviews(updatedReviews);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <Container>
            <Row>
                <Col><h3>Reviews</h3></Col>
            </Row>
            <Row className="mt-2">
                <Col>
                    <img src={movie?.poster} alt='' />
                </Col>
                <Col>
                    {
                        <>
                            <Row>
                                <Col>
                                    <ReviewForm revText={revText} labelText="Write a review." handleSubmit={addReview} />
                                </Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr />
                                </Col>
                            </Row>
                        </>
                    }
                    {
                        reviews?.map((r,idx) => {
                            return (
                                <div key={idx}>
                                    <Row>
                                        <Col>{r.body}</Col>
                                    </Row>
                                    <Row>
                                        <Col>
                                            <hr />
                                        </Col>
                                    </Row>
                                </div>
                            )
                        })
                    }
                </Col>
            </Row>
            <Row>
                <Col>
                    <hr />
                </Col>
            </Row>
        </Container>
    )
}

export default Reviews