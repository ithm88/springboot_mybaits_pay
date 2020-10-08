package com.item.service;

import com.item.bean.ResultUser;
import com.item.bean.User;
import com.item.bean.Users;
import com.item.mapper.UserMapper;
import com.item.itemsms.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//服务端的注解
@Service
@Transactional(rollbackFor = RuntimeException.class) //把事务管理交给spring来处理
public class UserService {

   @Autowired
    private UserMapper userMapper;

   @Autowired
   private RedisTemplate redisTemplate;
   /*
   *    注册
   * param user 参数封装
   * return result 返回的参数
   * */
    public ResultUser regist(User user) {
        //创建一个对象接收客户端传过来的参数
        ResultUser result = new ResultUser();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            //获取用户名,这里是调用mapper层的getUsername来判断是否正确
            User existUser = userMapper.findUserByName(user.getUsername());
            //判断请求数据库的是否为null
            if(existUser != null){
                //如果用户名存在,那么我们就返回
                result.setMsg("用户名已存在");
            }else{
                user.setPassword(MD5Utils.md5(user.getPassword()));
                //如果用户不存在,那么就存入到sql里面
                userMapper.regist(user);
                System.out.println(user.getId());
                result.setMsg("注册成功");
                //注册成功
                result.setSuccess(true);
                //注册成功后返回用户名给前端
                result.setDetail(user);
            }
            //return null;
        } catch (Exception e) {
            //这里是异常,把异常跑出去给前端展示
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        //返回当前数据的状态
        return result;
    }

    /*
    * 登录功能的实现
    * param user 用户名和密码
    * return Result
    * */
    //传入一个对象,返回状态封装到Result中
    public ResultUser login(User user) {
        //创建一个登录状态对象
        ResultUser result = new ResultUser();
        result.setSuccess(false); //这里是设置初始值
        result.setDetail(null); //这里设置初始值为null

        try {
            //把controll端传来的user对象数据传到dao层(也就是mapper层)
            Long userId = userMapper.login(user);
            //判断用户user的id是否为null
            if(userId == null){
                result.setMsg("用户名和密码错误");
            }else{
                result.setMsg(("登录成功"));
                result.setSuccess(true); //设置为登录成功true
                user.setId(userId);
                result.setDetail(user);
            }

        } catch (Exception e) {
            //如果登录异常,我们就要返回异常到前端
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /*
    * 这个是存入到redis数据库
    * */
    public List<Users> findRedis() {
        //查询redis,如果有值,直接返回  然后强转为listUser
        List<Users> users = (List<Users>) redisTemplate.boundValueOps("ererererer").get();
        System.out.println("查询redis里面的数据"+users);
        System.out.println("拿到了users"+users);
        //判断一下 这个键对应的值是否等于null
        if(users != null && users.size()>0){
            return users;
        }
        //如果redis没有值的话,我们就要查询mysql数据库, 并且将其保存到redis数据库中
        users = userMapper.findRedis();
        System.out.println("mysql数据库查到了数据"+users);
        //在查询到数据库不为空的情况下,然后存到redis中
        if(users != null && users.size() > 0){
            System.out.println("存入redis进来了");
            redisTemplate.boundValueOps("ererererer").set(users);
        }
        //打印redis数据库
        System.out.println(users);
        //mysql数据库中 和redis 都存入了之后,要返回到客户端
        return users;
    }
}
