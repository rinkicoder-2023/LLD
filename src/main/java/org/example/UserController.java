package org.example;

import java.util.List;

public class UserController {

    private final UserService userService = new UserService();

    public void addUser(String name, String email) {
        User user = userService.createUser(name, email);
        System.out.println("User added: " + user);
    }

    public void listUsers() {
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    public void getUserById(String userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User not found.");
        }
    }

    public void getUserByEmail(String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User not found.");
        }
    }

    public void removeUser(String userId) {
        boolean isDeleted = userService.removeUser(userId);
        System.out.println(isDeleted ? "User deleted successfully." : "User not found.");
    }
}
