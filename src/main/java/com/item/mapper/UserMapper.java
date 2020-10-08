package com.item.mapper;

import com.item.bean.User;
import com.item.bean.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//这里为什么没有创建类,是因为dao层交给mybatis管理了,直接用注解开发
@Mapper  //标记mapper文件位置,否则在Application.class启动类上配置mapper包扫描
@Repository
public interface UserMapper {

    /*
    * 查询用户名是否存在,若存在,不允许注册
    * 注解@Param(value) 若value与可变参数相同,注解可省略
    * 注解@Results 列名和字段名先沟通呢,注解可省略
    * @param username
    * @return
    * */
    @Select(value = "select u.username,u.password from tt_user u where u.username=#{username}")
    @Results
            ({@Result(property = "username",column = "username"),
              @Result(property = "password",column = "password")
            })

    User findUserByName(@Param("username") String username);

    /*
    * 注册一条user,插入一条记录
    * @param user
    * @return
    * */
    @Insert("insert into tt_user values(#{id},#{username},#{password})")
    //加入该注解可以保存都想后,查看查看对象插入的id
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void regist(User user);

    /*
    * 登录
    * param user
    * return
    * */
    @Select("select u.id from tt_user u where u.username = #{username} and password = #{password}")
    Long login(User user);

    @Select("select * from users")
    List<Users> findRedis();
}
