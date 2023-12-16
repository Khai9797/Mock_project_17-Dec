package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingUserForm {
    private String fullName;
    private String email;
    private String username;
    private String password;
}
