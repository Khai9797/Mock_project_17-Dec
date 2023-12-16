package com.vti.controller;

import com.vti.dto.UserDTO;
import com.vti.entity.User;
import com.vti.filter.UserFilter;
import com.vti.form.CreatingUserForm;
import com.vti.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    private Page<UserDTO> getAllUsers(Pageable pageable, UserFilter filter){
        Page<User> userPage = userService.getAllUsers(pageable, filter);
        List<User> users = userPage.getContent();
        List<UserDTO> userDTOS = modelMapper.map(users, new TypeToken<List<UserDTO>>() {

        }.getType());
        return new PageImpl<>(userDTOS, pageable,userPage.getTotalElements());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @PostMapping
    public void createUser(@RequestBody CreatingUserForm form) {
        userService.createUser(form);
    }
    @GetMapping(value = "/email/{email}")
    public ResponseEntity<?> existsUserByEmail(@PathVariable(name = "email") String email) {
        // get entity
        boolean result = userService.existsUserByEmail(email);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/userName/{userName}")
    public ResponseEntity<?> existsUserByUserName(@PathVariable(name = "userName") String userName) {
        // get entity
        boolean result = userService.existsUserByUserName(userName);

        // return result
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
