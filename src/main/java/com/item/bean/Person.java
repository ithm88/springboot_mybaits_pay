package com.item.bean;

import java.io.Serializable;

public class Person implements Serializable {
    /**
    * id 自增主键
     * name 人员姓名
     * mobile人员你电话
    * */
    private Integer id;
    private String name;
    private String mobile;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
