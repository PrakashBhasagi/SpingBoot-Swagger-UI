package com.prakash.service;

import java.util.List;

import com.prakash.bean.User;

/**
 * The Interface UserService.
 */

public interface UserService {

    /**
     * Gets the user by name.
     */
    public User getUserByUserName(String username);

    public List<User> getByUsernameContaining(String username);

    /**
     * Save User
     */
    User saveUser(User user);

    /**
     * remove User
     */
    int removeUser(Long id);

    /**
     * Update User
     */
    User updateUser(User user);

    /**
     * Get by User ID
     */
    User getUserById(Long id);

    /**
     * List Users
     */
    List<User> listUsers();
}
