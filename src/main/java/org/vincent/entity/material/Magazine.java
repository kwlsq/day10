package org.vincent.entity.material;

public class Magazine extends MaterialImpl{
    public Magazine(String title, Integer stock, String borrowedBy){
        super(title,stock,borrowedBy);
    }

    @Override
    public String borrow(){
        return "Magazine Borrowed: ";
    }
}
