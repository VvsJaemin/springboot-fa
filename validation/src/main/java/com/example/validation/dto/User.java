package com.example.validation.dto;

import com.example.validation.annotation.YearMonth;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class User {
    private String name;

    private int age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{4}=\\d{4}$", message = "핸드폰 번호를 올바르게 입력하세요")
    private String phoneNumber;

    @YearMonth
    private String reqYearMonth;



}
