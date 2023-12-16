package com.vti.service;

import com.vti.entity.User;
import com.vti.filter.UserFilter;
import com.vti.form.CreatingUserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    Page<User> getAllUsers(Pageable pageable, UserFilter form);

    User getUserById(int id);

    User getUserByUsername(String username);

    void createUser(CreatingUserForm form);
    boolean existsUserByEmail(String email);

    boolean existsUserByUserName(String userName);
    User findUserByEmail(String email);
}
