package com.example.app.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.user.model.User;
import com.example.app.user.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User saveProduct(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public List<User> getAllProducts() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> getProductById(Integer id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteProduct(Integer id) {
        userRepository.deleteById(id);
    }
}
