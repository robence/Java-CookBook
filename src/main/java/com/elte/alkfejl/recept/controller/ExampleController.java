package com.elte.alkfejl.recept.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {


    @GetMapping("/")
    String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        return ResponseEntity.ok(map);
    }
}