package com.morandev.moviesapi.controller;

import com.morandev.moviesapi.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class MessageController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> getRootMessage() {
        final String mensaje = "Por favor, intente conectarse desde el cliente web!";
        Message ms = new Message(mensaje, true);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ms);
    }
}
