package org.vincent.entity.menu;

import org.vincent.entity.material.MaterialImpl;
import org.vincent.entity.user.Role;
import org.vincent.entity.user.UserImpl;

import java.util.HashMap;
import java.util.Scanner;

public class Auth {
    Scanner scanner = new Scanner(System.in);

    HashMap<String, UserImpl> userList = new HashMap<>();
    HashMap<String, MaterialImpl> materialList = new HashMap<>();

    public void login() {
        userList.put("Jane", new UserImpl("Jane", Role.ADMIN, "123"));
        userList.put("John", new UserImpl("John", Role.VIP_MEMBER, "123"));
        userList.put("Jenny", new UserImpl("Jenny", Role.MEMBER, "123"));

        System.out.println("Welcome to the El-Grande Library");

        while (true) {
            System.out.println("Enter username: ");
            String username = scanner.next();

            System.out.println("Enter password: ");
            String password = scanner.next();

            UserImpl user = userList.get(username);
            if (user != null && user.authLogin(username, password)) {
                System.out.println("Login successful!\nWelcome, " + username + "!\n");
                Role role = user.getRole();
                Library library = new Library();
                library.libraryPrompt(role,user);
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }

}
