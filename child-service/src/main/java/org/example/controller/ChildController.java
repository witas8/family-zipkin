package org.example.controller;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.ChildService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService service;

    @GetMapping("/ask")
    @Observed(
            name = "metrics:child",
            contextualName = "span:child->father",
            lowCardinalityKeyValues = {"tagType", "child"}
    )
    public ResponseEntity<String> ask() {
        return ResponseEntity.ok(service.askFather());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.info("hello");
        return ResponseEntity.ok("Hello, it's Child!");
    }

}
