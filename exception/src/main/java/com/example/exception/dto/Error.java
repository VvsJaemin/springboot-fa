package com.example.exception.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Error {
    private String field;
    private String message;
    private String invalidValue;
}
