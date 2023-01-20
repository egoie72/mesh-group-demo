package com.meshgroup.demo.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserFilterDto {
    private final String name;
    private final String phone;
    private final String email;
    private final LocalDate dateOfBirth;
}
