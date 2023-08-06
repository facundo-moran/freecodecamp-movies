package com.morandev.moviesapi.controller;

import com.morandev.moviesapi.model.RootMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class RootController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RootMessageDto> getRootMessage() {
        final String mensaje = "Por favor, intente conectarse desde el cliente web!";
        RootMessageDto ms = new RootMessageDto(mensaje, true);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ms);
    }
}
