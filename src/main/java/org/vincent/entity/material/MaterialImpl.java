package org.vincent.entity.material;

import org.vincent.entity.user.UserImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MaterialImpl implements Material{
    private final UUID materialID;
    protected final String title;
    private Integer stock;
    private boolean isAvailable;
    private List<String> borrowedBy;

    public MaterialImpl(String title, Integer stock) {
        this.materialID = UUID.randomUUID();
        this.title = title;
        this.stock = stock;
        this.borrowedBy = new ArrayList<String>();
        this.isAvailable = true;
    }

    @Override
    public void borrow(UserImpl currentUser) {
        this.stock--;
        if(this.stock == 0){
            this.isAvailable = false;
        }
        this.borrowedBy.add(currentUser.getName());
    }

    @Override
    public void returnBorrow(UserImpl currentUser) {
        this.stock++;
        this.isAvailable = true;
        this.borrowedBy.remove(currentUser.getName());
    }

    public String getTitle(){
        return this.title;
    }

    public List<String> getBorrowedBy(){
        return this.borrowedBy;
    }

    public int getStock(){
        return this.stock;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public List<String> borrowedBy(){
        return this.borrowedBy;
    }
}


