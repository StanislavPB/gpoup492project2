package org.gpoup492project2.services;


import org.gpoup492project2.Repository.UserRepository;
import org.gpoup492project2.entity.User;

import java.util.Optional;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userRepository.addUser(user);
        System.out.println("Пользователь " + username + " зарегистрирован");
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public User createUser(int id, String name, String surname, String login, String password) {
        User user = new User(id, name, surname, login, password, name);
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}

