package org.vincent.entity.material;

public class Book extends MaterialImpl {
    public Book(String title, Integer stock){
        super(title,stock);
    }

    @Override
    public String getTitle(){
        return "Book title: " + title;
    }

}
