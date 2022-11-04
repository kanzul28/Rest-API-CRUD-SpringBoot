package com.project.test.service;

import com.project.test.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAllUser();

    Optional<User> findById(Long id);

    User saveUser(User user);

    User updateUser(User user,Long id);

    String deleteUser(Long id);
}
