package org.example.controller;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.example.service.FatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/father")
@RequiredArgsConstructor
public class FatherController {

    private final FatherService service;

    @GetMapping ("/answer")
    @Observed(
            name = "metrics:father",
            contextualName = "span:father->mother",
            lowCardinalityKeyValues = {"tagType", "father"}
    )
    public ResponseEntity<String> answer() {
        return ResponseEntity.ok(service.askMom());
    }
}
