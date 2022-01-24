package com.example.aop.controller;

import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Log4j2
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        log.info("get method");
        log.info("get method" + id);
        log.info("get method" + name);

        return id + "" + name;
    }
    @PostMapping("/post")
    public User post(@RequestBody User user) {
        log.info("post method  :" +user);

        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        // db logic
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user) {
        log.info("put method  :" +user);

        return user;
    }
}
