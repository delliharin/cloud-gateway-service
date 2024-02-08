package com.example.cloudgatewayservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GatewayController {
    @GetMapping("/{id}")
    public ResponseEntity<String> helloWorld(@PathVariable String id) {
        System.out.println("APM ID::" + id);
        return ResponseEntity.ok(id);
    }

}
