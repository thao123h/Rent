package com.he187184.mvc.rent.dto.response;

import com.he187184.mvc.rent.common.Role;
import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String email;
    private Role role;

    public JwtResponse(String accessToken,Integer id, String username, String email, Role role) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

}