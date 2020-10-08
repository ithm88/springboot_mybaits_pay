package com.item.bean;

public class OrderPayAll {
    private Integer id_p;
    private String telephone;
    private String orderNo;
    private String body;
    private String price;
    private String trade_state;
    private Integer pid;

    @Override
    public String toString() {
        return "OrderPayAll{" +
                "id_p=" + id_p +
                ", telephone='" + telephone + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", body='" + body + '\'' +
                ", price='" + price + '\'' +
                ", trade_state='" + trade_state + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Integer getId_p() {
        return id_p;
    }

    public void setId_p(Integer id_p) {
        this.id_p = id_p;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
