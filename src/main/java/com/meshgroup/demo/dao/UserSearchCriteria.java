package com.meshgroup.demo.dao;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserSearchCriteria {
    private final String name;
    private final String phone;
    private final String email;
    private final LocalDate dateOfBirth;

    public boolean isFullFilled() {
        return name != null || phone != null || email != null || dateOfBirth != null;
    }
}
