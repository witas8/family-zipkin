package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChildService {

    private final RestTemplate restTemplate;

    public String askFather(){
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8082/father/answer",
                HttpMethod.GET,
                null,
                String.class
        );
        log.info("Child has asked father for an answer");

        return response.getBody();
    }
}
