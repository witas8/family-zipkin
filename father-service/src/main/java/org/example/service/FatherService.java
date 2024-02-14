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
public class FatherService {

    private final RestTemplate restTemplate;

    public String askMom(){
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8083/mother/answer",
                HttpMethod.GET,
                null,
                String.class
        );
        log.info("Father has asked child's mother for an answer for his child");

        return response.getBody();
    }
}
