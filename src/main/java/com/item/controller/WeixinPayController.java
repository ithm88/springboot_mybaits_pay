package com.item.controller;

import com.item.bean.StatusCode;
import com.item.service.WeixinPayService;
import com.item.itemsms.Resultss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/weixin/pay")
public class WeixinPayController {

    @Autowired
    private WeixinPayService weixinPayService;

    @RequestMapping("/create/native")
    public Resultss<Map> createNative(String out_trade_no, String total_fee){

        //把创建的订单号用一个map集合存取
        Map<String,String> resultMap = weixinPayService.createNative(out_trade_no,total_fee);

        return new Resultss<Map>(true, StatusCode.OK,"二维码连接地址创建成功",resultMap);
    }
}
