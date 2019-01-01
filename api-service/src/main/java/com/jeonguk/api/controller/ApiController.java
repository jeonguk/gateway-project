package com.jeonguk.api.controller;

import com.jeonguk.api.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/user")
    public User getUser() {
        return User.builder().firstName("jeonguk").lastName("lee").build();
    }

    @GetMapping("/hello")
    public User getHello() throws InterruptedException {
        Thread.sleep(3000);
        return User.builder().firstName("Hello").lastName("World").build();
    }

}
