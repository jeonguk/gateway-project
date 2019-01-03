package com.jeonguk.gateway;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GateWayApplicationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetUser() {
        webTestClient.get().uri("/gateway/user")
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .consumeWith(response ->
                Assertions.assertThat(response.getResponseBody()).isNotNull());
    }
}
