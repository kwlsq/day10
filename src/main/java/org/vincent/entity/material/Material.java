package org.vincent.entity.material;

import org.vincent.entity.user.UserImpl;

public interface Material {
    public void borrow(UserImpl username);
    public void returnBorrow(UserImpl username);
}