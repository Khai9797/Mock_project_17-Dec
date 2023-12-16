package com.vti.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LoginInfoDTO {
    private String username;
    private String fullName;
    private String role;
}
