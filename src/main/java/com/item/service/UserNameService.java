package com.item.service;

import com.item.bean.Result;
import com.item.bean.UserName;
import com.item.mapper.UserNameMapper;
import com.item.itemsms.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class) //把事物交给spring处理
public class UserNameService {

    @Autowired
    UserNameMapper userNameMapper;

    /**
    * 注册的方法
    * */
    public Result regist(UserName userName){
        //创建一个对象接受客户端传过来的参数
        Result result = new Result();
        //提前设置一个默认值
        result.setFlag(false);
        try {
            //获取用户名,这里是调用mapper层的getUsername来判断是否正确
            UserName existUser = userNameMapper.findUserByName(userName.getTelephone());
            //判断请求数据库的值是否是null
            if(existUser != null){
                //如果用户名存在,那么我们就返回用户名存在
                result.setMessage("用户名存在");
            }else{
                userName.setPassword(MD5Utils.md5(userName.getPassword()));
                //如果用户名不存在,那么我们就存入到数据库中
                userNameMapper.regist(userName);
                System.out.println(userName.getId());
                result.setMessage("注册成功");
                result.setFlag(true);
                //注册成功后返回给客户端
                result.setData(userName);
            }
        }catch(Exception e){
            //这里是异常,把异常抛出去给前端展示
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        //返回当前数据的状态
        return result;
    }

    /**
    * 登录校验的方法
    * */
    public Result loginUser(UserName userName ) {

        Result result = new Result();
        result.setFlag(false);
        result.setData(null);
        System.out.println("服务端打印对象"+userName);
        System.out.println("服务端拿到手机号"+userName.getTelephone());
        System.out.println("服务端拿到密码"+userName.getPassword());
        userName.setPassword(MD5Utils.md5(userName.getPassword()));
        System.out.println("服务端拿到加密后的密码"+userName.getPassword());
        //获取用户名,这里是调用mapper层的getUsername来判断是否正确
        UserName userByName = userNameMapper.findUserPhone(userName);
        System.out.println("打印判断登录查询返回的结果"+userByName);

        //判断数据查询成功
        if (userByName != null){
            result.setMessage("登录成功");
            result.setFlag(true);
            result.setData(userByName);
        }else{
            result.setMessage("用户名或密码错误");
            result.setFlag(false);
        }
        return result;
    }
}


















