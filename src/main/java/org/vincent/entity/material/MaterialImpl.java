package org.vincent.entity.material;

public class MaterialImpl implements Material{
    private final String title;
    private Integer stock;
    private boolean isAvailable;
    private String borrowedBy;

    public MaterialImpl(String title, Integer stock, String borrowedBy) {
        this.title = title;
        this.stock = stock;
        this.borrowedBy = borrowedBy;
        this.isAvailable = true;
    }

    @Override
    public String borrow() {
        return "";
    }

    @Override
    public String returnBorrow() {
        return "";
    }

    public String getTitle(){
        return this.title;
    }

    public boolean getIsAvailable(){
        return this.isAvailable;
    }

    public String borrowedBy(){
        return this.borrowedBy;
    }
}


