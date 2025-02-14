package org.vincent.entity;

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

}


