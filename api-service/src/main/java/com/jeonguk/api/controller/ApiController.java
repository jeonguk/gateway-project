package com.jeonguk.api.controller;

import com.jeonguk.api.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/user")
    public User getUser(@RequestHeader HttpHeaders headers) {
        headers.forEach((name, values) -> values.forEach(value -> log.info("HEAER name {}, value {}", name, value)));
        return User.builder().firstName("jeonguk").lastName("lee").build();
    }

    @PostMapping("/user")
    public Object postUser(@RequestHeader HttpHeaders headers, @RequestBody Object object) {
        headers.forEach((name, values) -> values.forEach(value -> log.info("HEAER name {}, value {}", name, value)));
        log.info("Request body {}", object.toString());
        return object;
    }

    @GetMapping("/hello")
    public User getHello() throws InterruptedException {
            Thread.sleep(3000);
        return User.builder().firstName("Hello").lastName("World").build();
    }


}
