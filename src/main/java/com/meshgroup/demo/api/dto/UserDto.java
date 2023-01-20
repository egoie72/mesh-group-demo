package com.meshgroup.demo.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {
    private final Long id;
    private final String name;
    private final LocalDate dateOfBirth;
    private final BigDecimal ballance;
    private final List<String> emails;
    private final List<String> phones;
}
