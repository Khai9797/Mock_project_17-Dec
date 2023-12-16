package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`User`")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`id`", unique = true, nullable = false)
	private int id;

	@Column(name = "`full_name`", nullable = false, length = 50)
	private String fullName;

	@Column(name = "`email`", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "`username`", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "`password`", nullable = false, length = 800)
	private String password;

	@Column(name = "`role`", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
}