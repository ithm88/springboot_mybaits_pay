package com.item.controller;


import com.item.api.WXPayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name: com.weixin.pay.controller
 * File Name: WXPayQueryController
 * Copyright (c) 2018, 3141621744@qq.com All Rights Reserved.
 *
 * @author Tobin
 */
@Controller
public class WXPayQueryController {

    @GetMapping("/payquery")
    public String payquery() {
        return "/payquery";
    }


    @PostMapping("/payquery")
    @ResponseBody
    public Map<Object, Object> payquery(ModelMap map, String orderNo) throws Exception {
        WXPayUtils wxPayUtils = new WXPayUtils();
        Map<String, String> rs = wxPayUtils.wxOrderQuery(orderNo);

        System.out.println("===============微信订单查询结果==============");
        System.out.println(rs);
        Map<Object, Object> objectMap = new HashMap<>();
        objectMap.put("payqueryMap",rs);
        //map.put("payqueryMap", rs.toString());
        //return "/payquery";
        return objectMap;
    }

}
