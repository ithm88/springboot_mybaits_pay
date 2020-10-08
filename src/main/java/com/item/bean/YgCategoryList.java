package com.item.bean;

public class YgCategoryList {
    private Integer cat_id;
    private String cat_name;
    private String cat_pid;
    private Integer cat_level;
    private Integer cat_deleted;
    private String cat_icon;
    private String cat_src;

    @Override
    public String toString() {
        return "YgCategoryList{" +
                "cat_id=" + cat_id +
                ", cat_name='" + cat_name + '\'' +
                ", cat_pid='" + cat_pid + '\'' +
                ", cat_level=" + cat_level +
                ", cat_deleted=" + cat_deleted +
                ", cat_icon='" + cat_icon + '\'' +
                ", cat_src='" + cat_src + '\'' +
                '}';
    }

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_pid() {
        return cat_pid;
    }

    public void setCat_pid(String cat_pid) {
        this.cat_pid = cat_pid;
    }

    public Integer getCat_level() {
        return cat_level;
    }

    public void setCat_level(Integer cat_level) {
        this.cat_level = cat_level;
    }

    public Integer getCat_deleted() {
        return cat_deleted;
    }

    public void setCat_deleted(Integer cat_deleted) {
        this.cat_deleted = cat_deleted;
    }

    public String getCat_icon() {
        return cat_icon;
    }

    public void setCat_icon(String cat_icon) {
        this.cat_icon = cat_icon;
    }

    public String getCat_src() {
        return cat_src;
    }

    public void setCat_src(String cat_src) {
        this.cat_src = cat_src;
    }
}
