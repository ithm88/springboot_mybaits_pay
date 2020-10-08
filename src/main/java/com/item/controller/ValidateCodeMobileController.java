package com.item.controller;
import com.item.bean.Result;
import com.item.constant.MessageConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/validateCode")
public class ValidateCodeMobileController{

//    @Autowired
//    JedisPool jedisPool;

    //发送验证码(场景:登录验证码)
    @RequestMapping(value = "/send4Login")
    public Result send4Login(String telephone) { //接收手机号
//        //1,传递手机号
//        //2,生成4为验证码,使用手机号,发送短信(SMSUtils.java)
//        Integer code4 = ValidateCodeUtils.generateValidateCode(4);
//        try {
//            SMSUtils.sendShortMessage(telephone,String.valueOf(code4));
//        } catch (ClientException e) {
//            e.printStackTrace();
//            new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
//        }
//        System.out.println("发送短信成功,验证码是"+code4);
//        //3,将生成的手机号放入到redis缓存里面<5分钟之后过期>  5 * 60秒  = 5分钟
//        //* key:                                 value:
//        //* 手机号+001                           验证码:
//        //* 如果放到集合,就是sadd
//        //* 如果删除,就是srem
//        //* 如果比较不同就是:sdiff
//        //* 如果字符串,就用set   专门用来放字符串的,永久存在的
//        //* 这里是存手机注册验证的验证码,不重要的用setex  临时存在的
//        //*
//        //这里是telephone+001 作为key  ,将验证码 code4转为字符串类型存入redis中作为value  ,中间的seconds是保存的时间时长,到了就自动删掉
//        jedisPool.getResource().setex(telephone + RedisMobileMessageConstant.SENDTYPE_GETPWD,100*60,code4.toString());
//        //没有异常就发送成功,返回给客户端,验证码发送成功
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

}
