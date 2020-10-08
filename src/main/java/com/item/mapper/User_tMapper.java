package com.item.mapper;

import com.item.bean.User_t;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@CacheNamespace
public interface User_tMapper {
    /*
    * 根据id查询用户信息的方法
    * 这两个方法就是对应的那两个sql语句
    * */
    @Results(id="userAccountId", value = {
            //在使用注解进行自定义映射规则的时候,如果字段名和属性名能够对应上,就可以不写,但是
            //作为参数传递到外部查询的方法中去的字段
            @Result(column = "id",property = "id",id=true),
            //进行一对多查询映射
            @Result(column = "id", property = "accountList",many = @Many(fetchType = FetchType.LAZY,select = "com.item.mapper.Account_tMapper.findAccountByAid"))
    })
    @Select("select * from user where id=#{id}")
    User_t findUserById(int id);

}
