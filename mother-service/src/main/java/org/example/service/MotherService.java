package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MotherService {

    private final RestTemplate restTemplate;

    public String motherAnswers(){
        log.info("Child's mother answers");
        return "No";
    }

}
