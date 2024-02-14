package org.example.controller;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.example.service.MotherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mother")
@RequiredArgsConstructor
public class MotherController {

    private final MotherService service;

    @GetMapping("/answer")
    @Observed(
            name = "metrics:mother",
            contextualName = "span:mother",
            lowCardinalityKeyValues = {"tagType", "mother"}
    )
    public ResponseEntity<String> answer(){
        return ResponseEntity.ok(service.motherAnswers());
    }

}
