package org.gpoup492project2.services;

import aMainProject.entity.User;
import aMainProject.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String password){
        User user = new User(username, password);
        userRepository.addUser(user);
        System.out.println("Пользователь " + username + " зарегистрирован");
    }

    public boolean authenticateUser(String username, String password){
        User user = userRepository.findUser(username);
        return user != null && user.getPassword().equals(password);
    }
}
