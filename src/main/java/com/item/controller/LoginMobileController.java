package com.item.controller;

import com.item.bean.Result;
import com.item.bean.UserName;
import com.item.constant.MessageConstant;
import com.item.constant.RedisMobileMessageConstant;
import com.item.service.UserNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@CrossOrigin  //支持跨域
@RestController
@RequestMapping(value = "/login")
public class LoginMobileController {

    @Autowired
    RedisTemplate redisTemplate;
    
    @Autowired
    UserNameService userNameService;
    //手机快速登录
    @RequestMapping(value="/check")
    @ResponseBody
    public Result submit(@RequestBody Map map, HttpServletResponse response) { //这里要返回存的cookie 存入倒response中
//        //获取用户输入的验证码
        String telephone = (String) map.get("templates"); //这里拿到的是一个string类型的,所有我们需要强转
        //在拿一个用户输入的验证阿妈
        String validateCode = (String) map.get("validateCode");
        //获取密码,存入数据库
        String password = (String) map.get("password");

        //从redis中获取验证码
        String redisValidateCode = (String) redisTemplate.opsForValue().get(telephone + RedisMobileMessageConstant.SENDTYPE_LOGIN);
        System.out.println("拿到前端的手机号为"+telephone);
        System.out.println("拿到的密码为"+password);
        System.out.println("拿到前端的验证码为"+validateCode);
        System.out.println("拿到redis的验证码为"+redisValidateCode);

        //拿到验证码之后校验,如果redisValidateCode 等于空,就是过期了,没有效果了,如果不等于空,和验证码跟redis里面的不相等,那么就校验失败
        if(redisValidateCode == null || !redisValidateCode.equals(validateCode)){
            return new Result(false,MessageConstant.VALIDATECODE_ERROR); //验证码输入错误
        }

        //到这里就是通过了的意思了,保存用户的登录状态,使用cookid来存放用户的信息,谁登录,我就存到cookie里面
        Cookie cookie = new Cookie("login_telphone_member",telephone);
        cookie.setPath("/"); //设置有效的路径
        cookie.setMaxAge(30*24*60*60); //有效期 30天
        response.addCookie(cookie); //存入cookie并响应到客户端
        //从redis中获取验证码
//        String redisValidateCode = jedisPool.getResource().get(telephone + RedisMobileMessageConstant.SENDTYPE_LOGIN);//拿到002验证码
//        //拿到验证码之后校验
//        //如果redisValidateCode 等于空,就是过期了,没有效果了 这里判断的都是验证码为空,和验证码不等于redis数据库中的验证码
//        //校验不通过
//        if (redisValidateCode == null || !redisValidateCode.equals(validateCode)) {
//            return new Result(false, MessageConstant.VALIDATECODE_ERROR); //验证码输入有误
//        }
////        //校验通过 看是不是会员,如果不是会员,就要注册会员
////        Member member = meberService.findMeberByTelephone(telephone);
////        //如果不是会员,就要注册会员,判断
////        if (member == null){
////            member = new Member();
////            //把手机号存入会员对象
////            member.setPhoneNumber(telephone);
////            //存入当前时间
////            member.setRegTime(new Date());
////            meberService.add(member);
////        }
//        //保存用户的登录状态 使用cookie 来存放用户的信息,谁登陆,我就存到cookie里面
//        Cookie cookie = new Cookie("login_telphone_member",telephone);
//        cookie.setPath("/"); //有效路劲
//        cookie.setMaxAge(30*24*60*60); //有效时间 30天
//        response.addCookie(cookie);
//        //登录成功
        return new Result(true,MessageConstant.LOGIN_SUCCESS);
    }
    @RequestMapping("/zhuce")
    @ResponseBody
    public Result zhuce(UserName username, HttpServletResponse response){
        //获取手机号
        String telephone = username.getTelephone();
        //获取密码
        String password = username.getPassword();
        //获取前端传过来的验证码
        String validateCode = username.getValidateCode();

        String udd = telephone + RedisMobileMessageConstant.SENDTYPE_LOGIN;
        System.out.println("拼接的东东"+udd);

        //从redis中获取验证码
        String redisValidateCode =(String) redisTemplate.opsForValue().get(telephone + RedisMobileMessageConstant.SENDTYPE_LOGIN);
        System.out.println("拿到前端的手机号为"+telephone);
        System.out.println("拿到的密码为"+ password);
        System.out.println("拿到的验证码为"+validateCode);
        System.out.println("拿到redis的验证码为"+redisValidateCode);
        //拿到验证码之后校验,如果redisValidateCode 等于空,就是过期了,没有效果了,
        // 如果不等于空,和验证码跟redis里面的不相等 那么校验失败
        if(redisValidateCode == null || !redisValidateCode.equals(validateCode)){
            return new Result(false,MessageConstant.VALIDATECODE_ERROR); //验证码输入错误
        }

        //到这里就是通过了的意思,保存用户的登录状态,使用cookid来存放用户的信息,谁登录我就存到cookie里面
//        Cookie cookie = new Cookie("login_telphone",telephone);
//        cookie.setPath("/"); //设置有效的路径
//        cookie.setMaxAge(30*24*60*1); //有效期1天
//        response.addCookie(cookie); //把cookie 响应到客户端

        //校验通过了,就给他注册,首先要判断一下手机号是否注册过
        Result regist = userNameService.regist(username);
        System.out.println(regist);
        return regist;
    }
    @RequestMapping("/loginUser")
    @ResponseBody
    public Result loginUser(UserName userName, HttpServletResponse response){
        //获取前端传来的账号
        String telephone = userName.getTelephone();
        //获取前端传来的密码
        String password = userName.getPassword();
        System.out.println("前端传来的账号"+ telephone);
        System.out.println("前端传来的密码"+password);
        //访问服务端进行查询校验
        Result result = userNameService.loginUser(userName);
        if(result.isFlag()){
            //到这里就是通过了的意思,保存用户的登录状态,使用cookid来存放用户的信息,谁登录我就存到cookie里面
            Cookie cookie = new Cookie("login_telphone", telephone);
            cookie.setPath("/"); //设置有效的路径
            cookie.setMaxAge(30*24*60*1); //有效期1天
            response.addCookie(cookie); //把cookie 响应到客户端
        }
        return result;
    }
}
