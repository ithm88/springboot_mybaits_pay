package com.item.bean;

public class CategoryFloorList {
    private Integer id;
    private Object categoryList;
    private Object floorTitle;

    @Override
    public String toString() {
        return "CategoryFloorList{" +
                "id=" + id +
                ", categoryList=" + categoryList +
                ", floorTitle=" + floorTitle +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Object categoryList) {
        this.categoryList = categoryList;
    }

    public Object getFloorTitle() {
        return floorTitle;
    }

    public void setFloorTitle(Object floorTitle) {
        this.floorTitle = floorTitle;
    }
}
