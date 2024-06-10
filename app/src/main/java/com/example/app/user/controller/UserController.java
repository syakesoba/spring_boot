package com.example.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.app.user.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model) {

        return "userList";
    }
    
}
