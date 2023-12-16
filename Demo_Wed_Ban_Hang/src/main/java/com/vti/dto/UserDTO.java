package com.vti.dto;

import com.vti.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private String fullName;
	private String email;
	private String username;
	private Role role;
}