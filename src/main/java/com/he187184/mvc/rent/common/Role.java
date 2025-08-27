package com.he187184.mvc.rent.common;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    admin,
    owner,
    renter;
    @JsonCreator
    public static Role fromString(String role) {
        return Role.valueOf(role.toUpperCase());
    }
}
