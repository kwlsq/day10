package org.vincent.entity.material;

public class Book extends MaterialImpl {
    public Book(String title, Integer stock, String borrowedBy){
        super(title,stock,borrowedBy);
    }

    @Override
    public String borrow(){
        return "Book Borrowed: ";
    }

}
