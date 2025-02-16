package org.vincent.entity.material;

public class Magazine extends MaterialImpl{
    public Magazine(String title, Integer stock){
        super(title,stock);
    }

//    @Override
//    public String borrow(){
//        return "Magazine Borrowed: ";
//    }

    @Override
    public String getTitle(){
        return "Magazine title: " + title;
    }
}
