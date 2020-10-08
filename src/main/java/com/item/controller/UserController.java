package com.item.controller;

import com.aliyuncs.exceptions.ClientException;
import com.item.bean.Result;
import com.item.bean.ResultUser;
import com.item.bean.User;
import com.item.constant.MessageConstant;
import com.item.constant.RedisMobileMessageConstant;
import com.item.service.UserService;
import com.item.itemsms.SMSUtils;
import com.item.itemsms.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;
@CrossOrigin  //支持跨域
@RestController  //restf风格
@RequestMapping("/user")
public class UserController {

    //自动注册关联到服务端
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;
    /*
    * 注册功能
    * param user 参数封装
    * return Result
    * */
    @PostMapping(value = "/regist")
    public ResultUser regist(User user){
        //把获取的参数返回到服务端service
        //这里是把前端传来的数据用一个对象接收来封装,然后去数据库请求验证账号密码
        return userService.regist(user);
    }

    /*
    * 登录功能
    * @apram.user 参数封装
    * return Result
    * */
    @PostMapping(value="/login")
    public ResultUser login(User user){
        System.out.println("打印前端获取的数据"+user);
        return userService.login(user);
    }

    /*
    * redis功能
    * */
    @RequestMapping(value="/findRedis")
    @ResponseBody
    public Result findRedis(String telephone){
        System.out.println("手机号进来了");
        //生成4位数字的验证码
        Integer code = ValidateCodeUtils.generateValidateCode(4); //生成4位数字
        try{
            //发送短信
            System.out.println("进入发送短信功能进来了");
            SMSUtils.sendShortMessage(telephone,code.toString());
        }catch(ClientException e){
            e.printStackTrace();
            //验证码发送失败
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL); //验证码发送失败
        }
        System.out.println("发送的手机验证码为:"+code);
        //第一种存永久,,,,,如果没有异常,将生成的验证码缓存到redis中
        //redisTemplate.boundValueOps(telephone+ RedisMobileMessageConstant.SENDTYPE_LOGIN).set(code.toString());
        //设置gubangjie 的保存时间为100秒
        //第二种有限制时间的,,,,,
        redisTemplate.opsForValue().set(telephone+ RedisMobileMessageConstant.SENDTYPE_LOGIN,code.toString(),60, TimeUnit.SECONDS); //TimeUnit.SECONDS意思是线程等待5秒

        //获取redis里面的值
        Object gubangjie = redisTemplate.opsForValue().get(telephone+ RedisMobileMessageConstant.SENDTYPE_LOGIN);//这个是获取redis里面的值

        System.out.println("存入redis完毕"+gubangjie);
        return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);

    }
}



























