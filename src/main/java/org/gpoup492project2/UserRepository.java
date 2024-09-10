package org.gpoup492project2;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> userMap = new HashMap<>();


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

    public Map<String, User> getAllUsers() {
        return userMap;
    }
}
