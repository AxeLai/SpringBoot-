package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author AxeLai
 * @date 2019-04-18 14:59
 */
@RestController
@Api(value = "UserController",description = "用户端")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户")
    public boolean addUser( User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户信息")
    public boolean updateUser( User user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ApiOperation(value = "通过用户id删除用户信息")
    public boolean delete(@RequestParam(value = "userId", required = true) int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation(value = "通过用户名查询用户信息")
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }


    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有用户信息")
    public List<User> findAll() {
        System.out.println("开始查询所有数据...");
        return userService.findAll();
    }

}
