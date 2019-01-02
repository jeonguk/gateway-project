package com.jeonguk.gateway.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/gateway")
public class GateWayController {

    @GetMapping("/user")
    public Authority getAuth() {
        return Authority.builder().userId("aaaaaaaaaa").firstName("jeonguk").lastName("lee").build();
    }

    @Getter
    @Setter
    @Builder
    public static class Authority {
        private String userId;
        private String firstName;
        private String lastName;
    }
}
