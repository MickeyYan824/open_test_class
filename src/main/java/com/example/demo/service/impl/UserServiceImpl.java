package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public int updateUser(Long id, String userName, String userPassword, String userType, String updatedBy, LocalDate updatedTime) {
        return userRepository.updateUser(id, userName, userPassword, userType, updatedBy, updatedTime);
    }

    @Override
    public List<User> findAll(Sort sort) {
        return userRepository.findAll(sort);
    }
}
