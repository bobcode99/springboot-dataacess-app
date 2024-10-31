package com.example.dbservice.controller;

import com.example.dbservice.po.UserInfoPO;
import com.example.dbservice.service.DataAccessService;
import com.example.dbservice.vo.UserInfoVO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/db")
@RequiredArgsConstructor
public class DataAccessController {

    private final DataAccessService dataAccessService;
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
    @GetMapping("/user")
    public ResponseEntity<UserInfoPO> getUser(@RequestParam String id) {
       var user = dataAccessService.getSingleUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<Integer> createUser(@Valid @RequestBody UserInfoVO userInfoVO) {
        int create = dataAccessService.createUserInfo(userInfoVO);
        return ResponseEntity.ok(create);
    }

}
