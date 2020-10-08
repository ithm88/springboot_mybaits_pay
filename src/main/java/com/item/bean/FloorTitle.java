package com.item.bean;

import java.util.List;

public class FloorTitle {
    private Integer id;
    private String name;
    private String image_src;
    private Integer p_id;
    private List<ProductList> productList;

    @Override
    public String toString() {
        return "FloorTitle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_src='" + image_src + '\'' +
                ", p_id=" + p_id +
                ", productList=" + productList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public List<ProductList> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductList> productList) {
        this.productList = productList;
    }
}
