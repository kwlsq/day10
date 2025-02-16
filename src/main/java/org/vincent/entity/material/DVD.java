package org.vincent.entity.material;

public class DVD extends MaterialImpl{
    public DVD(String title, Integer stock){
        super(title,stock);
    }

//    @Override
//    public String borrow(){
//        return "DVD Borrowed: ";
//    }

    @Override
    public String getTitle(){
        return "DVD title: " + title;
    }
}
