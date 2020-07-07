package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    User save(User user);

    void deleteById(Long id);

    int updateUser(Long id, String userName, String userPassword, String userType, String updatedBy, LocalDate updatedTime);

    List<User> findAll(Sort sort);

}
