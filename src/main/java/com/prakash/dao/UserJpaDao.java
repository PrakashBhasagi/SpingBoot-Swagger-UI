package com.prakash.dao;

import com.prakash.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserJpaDao extends JpaRepository<User, Long> {


    User findByName(String name);

    User getOne(Long id);

    List<User> findByUsernameContaining(String username);

    User getByUsernameIs(String username);

    @Query("select s from User s where name like CONCAT('%',:name,'%')")
    List<User> findByNameLike(@Param("name") String name);


}