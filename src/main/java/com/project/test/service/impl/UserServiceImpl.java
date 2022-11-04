package com.project.test.service.impl;

import com.project.test.entity.User;
import com.project.test.entity.UserContact;
import com.project.test.repository.UserContactRepository;
import com.project.test.repository.UserRepository;
import com.project.test.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserContactRepository userContactRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        UserContact user_contact = user.getUserContact();
        user.setUserContact(user_contact);
        user_contact.setUser(user);
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user,Long id) {
        UserContact user_contact = user.getUserContact();
        User params =  userRepository.findById(id).get();
        params.setUserContact(user_contact);
        params.setName(user.getName());
        params.setAge(user.getAge());
        return userRepository.save(params);

    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}
