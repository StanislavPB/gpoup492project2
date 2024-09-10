package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();


    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }

    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    public void deleteUser(String id) {
        userMap.remove(id);
    }

    public Map<Integer, User> getAllUsers() {
        return userMap;
    }
}
