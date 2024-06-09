package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
}
