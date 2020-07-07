package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    User save(User user);

    @Override
    @Modifying
    @Query(value = "delete from user where id = ?1", nativeQuery = true)
    void deleteById(Long id);

    @Modifying
    @Query(value = "update User u set u.userName = ?2 , u.userPassword = ?3 , u.userType = ?4 , u.updatedBy = ?5 , u.updatedTime = ?6 where u.id = ?1", nativeQuery = true)
    int updateUser(Long id, String userName, String userPassword, String userType, String updatedBy, LocalDate updatedTime);

    @Override
    List<User> findAll(Sort sort);

}
