package com.example.exception.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class User {

    @NotEmpty
    @Size(min = 1, max = 10)
    private String name;

    @Min(1)
    @NonNull
    private Integer age;
}
