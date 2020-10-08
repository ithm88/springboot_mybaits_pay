package com.item.bean;

public class ProductList {
    private Integer id_p;
    private String name;
    private String image_srcc;
    private String image_width;
    private String open_type;
    private String navigator_url;
    private Integer pid;

    @Override
    public String toString() {
        return "ProductList{" +
                "id_p=" + id_p +
                ", name='" + name + '\'' +
                ", image_srcc='" + image_srcc + '\'' +
                ", image_width='" + image_width + '\'' +
                ", open_type='" + open_type + '\'' +
                ", navigator_url='" + navigator_url + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Integer getId_p() {
        return id_p;
    }

    public void setId_p(Integer id_p) {
        this.id_p = id_p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_srcc() {
        return image_srcc;
    }

    public void setImage_srcc(String image_srcc) {
        this.image_srcc = image_srcc;
    }

    public String getImage_width() {
        return image_width;
    }

    public void setImage_width(String image_width) {
        this.image_width = image_width;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public String getNavigator_url() {
        return navigator_url;
    }

    public void setNavigator_url(String navigator_url) {
        this.navigator_url = navigator_url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
