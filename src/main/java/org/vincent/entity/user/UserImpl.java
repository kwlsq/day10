package org.vincent.entity.user;

public class UserImpl {
    private String name;
    private Role role;
    private String password;

    public UserImpl(String name, Role role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
    }

    public boolean authLogin(String userName, String password) {
        return !userName.isEmpty() && !password.isEmpty() && this.name.equalsIgnoreCase(userName) && this.password.equalsIgnoreCase(password);
    }

}
