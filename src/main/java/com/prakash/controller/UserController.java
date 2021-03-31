package com.prakash.controller;

import com.prakash.bean.User;
import com.prakash.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/users")
@Api(value = "UserService")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * api :localhost:8099/users
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "FindAll", notes = "Find All operation")
    @ApiParam(value = "ID")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    /**
     * api :localhost:8099/users/1
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "getUserById", notes = "getUserById operation")
    public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserById(Long.valueOf(id)), HttpStatus.OK);
    }


    /**
     * api :localhost:8099/users
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ApiModelProperty(value = "user", notes = "default user")
    @ApiOperation(value = "saveUser", notes = "saveUser operation")
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    /**
     * api :localhost:8099/users
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @ApiModelProperty(value = "user", notes = "default user")
    @ApiOperation(value = "updateUser", notes = "updateUser operation")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    /**
     * api :localhost:8099/users/2
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "deleteUser", notes = "deleteUser operation")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.removeUser(id.longValue()), HttpStatus.OK);
    }
}