package com.item.bean;

public class SwiperList {
    private Integer id;
    private String image_src;
    private String open_type;
    private String goods_id;
    private String navigator_url;

    @Override
    public String toString() {
        return "SwiperList{" +
                "id=" + id +
                ", image_src='" + image_src + '\'' +
                ", open_type='" + open_type + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", navigator_url='" + navigator_url + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getNavigator_url() {
        return navigator_url;
    }

    public void setNavigator_url(String navigator_url) {
        this.navigator_url = navigator_url;
    }
}
