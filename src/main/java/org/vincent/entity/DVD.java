package org.vincent.entity;

public class DVD extends MaterialImpl{
    public DVD(String title, Integer stock, String borrowedBy){
        super(title,stock,borrowedBy);
    }

    @Override
    public String borrow(){
        return "DVD Borrowed: ";
    }
}
