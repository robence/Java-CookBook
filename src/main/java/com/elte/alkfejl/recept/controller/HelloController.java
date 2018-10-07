package com.elte.alkfejl.recept.controller;

import com.elte.alkfejl.recept.model.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello/{message}")
    Hello helloMessage(@PathVariable("message") String message) {
        log.info("message: " + message);
        Hello response = new Hello();
        response.setContent(message);
        return response;
    }
}
