package com.prakash.serviceImpl;

import com.prakash.bean.User;
import com.prakash.dao.UserJpaDao;
import com.prakash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserJpaDao userJpaDao;

    @Autowired
    private UserService userService;


    @Override
    public User getUserByUserName(String username) {
        return userJpaDao.getByUsernameIs(username);
    }

    @Override
    public List<User> getByUsernameContaining(String username) {
        return userJpaDao.findByUsernameContaining(username);
    }

    @Override
    public User saveUser(User user) {
        return userJpaDao.save(user);
    }

    @Override
    public int removeUser(Long id) {
        try {
            userJpaDao.deleteById(id);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public User updateUser(User user) {
        return userJpaDao.save(user);
    }

    @Override
    public User getUserById(Long id) {

        return userJpaDao.findById(id).get();
    }

    @Override
    public List<User> listUsers() {
        return userJpaDao.findAll();
    }
}
