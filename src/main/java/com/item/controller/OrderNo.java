package com.item.controller;

public class OrderNo {
    private String orderNo;
    private String body;
    private String price;

    @Override
    public String toString() {
        return "OrderNo{" +
                "orderNo='" + orderNo + '\'' +
                ", body='" + body + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
