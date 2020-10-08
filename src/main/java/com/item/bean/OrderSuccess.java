package com.item.bean;

public class OrderSuccess {
    private String trade_state;
    private String telephone;
    private String orderNo;

    @Override
    public String toString() {
        return "OrderSuccess{" +
                "trade_state='" + trade_state + '\'' +
                ", telephone='" + telephone + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
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
}
