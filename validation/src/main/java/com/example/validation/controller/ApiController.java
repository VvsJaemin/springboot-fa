package com.example.validation.controller;

import com.example.validation.dto.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Log4j2
public class ApiController {

    @PostMapping("/user")
    public Object user(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();
                log.info("fleid" + field.getField());
                log.info(message);

                sb.append("fleid" + field.getField());
                sb.append("message" + message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        log.info(user);


        if (user.getAge() >= 90) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

        return ResponseEntity.ok(user);
    }
}
