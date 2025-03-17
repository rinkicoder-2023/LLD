package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public User createUser(String name, String email) {
        User user = new User(name, email);
        users.put(user.getUserId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }

    public User getUserByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public boolean removeUser(String userId) {
        return users.remove(userId) != null;
    }
}
