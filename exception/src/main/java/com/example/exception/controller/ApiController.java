package com.example.exception.controller;

import com.example.exception.dto.User;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api")
@Log4j2
@Validated
public class ApiController {

    @GetMapping("")
    public User get(
            @Size(min = 2)
            @RequestParam(required = false) String name,

            @NonNull
            @Min(1)
            @RequestParam(required = false) Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        int a = 10 + age;

        return user;
    }

    @PostMapping("/user")
    public User post(@Valid @RequestBody User user) {
        log.info(user);
        return user;
    }

//    // 전역이 아닌 ApiController 클래스에서만 예외처리(글로벌보단 ApiController에 지정한 ExceptionHandler가 우선순위가 높다)
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.info("Api Controller");
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }
}
