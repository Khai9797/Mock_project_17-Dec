package com.vti.controller;

import com.vti.dto.LoginInfoDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/login")
    public LoginInfoDTO login(Principal principal) {
        String username = principal.getName();
        User user = userService.getUserByUsername(username);
        return modelMapper.map(user, LoginInfoDTO.class);
    }
}
