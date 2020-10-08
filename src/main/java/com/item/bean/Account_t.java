package com.item.bean;

public class Account_t {
    private Integer aid;
    private Double money;
    private Integer uid;
    private User_t user_t;

    @Override
    public String toString() {
        return "Account_t{" +
                "aid=" + aid +
                ", money=" + money +
                ", uid=" + uid +
                ", user_t=" + user_t +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public User_t getUser_t() {
        return user_t;
    }

    public void setUser_t(User_t user_t) {
        this.user_t = user_t;
    }
}
