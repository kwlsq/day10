package org.vincent.entity.user;

public class Admin extends UserImpl{
    public Admin(String name, Role role, String password) {
        super(name, role, password);
    }
}
