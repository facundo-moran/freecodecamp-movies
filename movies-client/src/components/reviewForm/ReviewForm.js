import React from 'react'
import { Form, Button, FormControl, FormLabel, FormGroup } from 'react-bootstrap'


const ReviewForm = ({handleSubmit, revText, labelText, defaultValue }) => {
    return (
        <Form>
            <FormGroup className='mb-3' controlId='exampleForm.ControlTextarea1'>
                <FormLabel>{labelText}</FormLabel>
                <FormControl ref={revText} as="textarea" rows={3} defaultValue={defaultValue} />
            </FormGroup>
            <Button variant='outline-info' onClick={handleSubmit}>Submit</Button>
        </Form>
    )
}

export default ReviewForm