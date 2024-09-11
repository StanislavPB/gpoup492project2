package org.gpoup492project2.Repository;


import org.gpoup492project2.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();

    // Метод для добавления пользователя
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    // Метод для получения пользователя по идентификатору
    public User getUserById(String id) {
        return userMap.get(id);
    }

    // Метод для обновления пользователя
    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    // Метод для удаления пользователя
    public void deleteUser(String id) {

    }
    // Метод для получения всех пользователей
    public Map<Integer, User> getAllUsers() {
        return userMap;
    }

    public void save(User user) {
    }
}
