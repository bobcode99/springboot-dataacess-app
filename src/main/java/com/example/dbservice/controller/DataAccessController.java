package com.example.dbservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db")
public class DataAccessController {
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
//    @GetMapping("/metadata/{queryId}")
//    public ResponseEntity<QueryMetadata> getQueryMetadata(
//            @PathVariable String queryId) {
//        return ResponseEntity.ok(databaseQueryService.getQueryMetadata(queryId));
//    }
}
