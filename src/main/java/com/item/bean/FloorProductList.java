package com.item.bean;

import java.util.List;

public class FloorProductList {
    private FloorTitle floorTitle;
    private List<ProductList> productLists;

    @Override
    public String toString() {
        return "FloorProductList{" +
                "floorTitle=" + floorTitle +
                ", productLists=" + productLists +
                '}';
    }

    public FloorTitle getFloorTitle() {
        return floorTitle;
    }

    public void setFloorTitle(FloorTitle floorTitle) {
        this.floorTitle = floorTitle;
    }

    public List<ProductList> getProductLists() {
        return productLists;
    }

    public void setProductLists(List<ProductList> productLists) {
        this.productLists = productLists;
    }
}
