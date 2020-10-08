package com.item.mapper;

import com.item.bean.UserName;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserNameMapper {

    /**
    * 注册一条user,插入一条记录
    * */
    @Insert("insert into tt_user values(#{id}, #{username},#{telephone},#{password},null)")
    //加入该朱姐可以保存都想后,查看查看对象插入的id
    @Options(useGeneratedKeys = true,keyProperty = "id" ,keyColumn = "id")
    void regist(UserName userName);


    /**
    * 查询用户名是否存在
    * */
    @Select(value="select u.telephone, u.password from tt_user u where u.telephone=#{telephone}")
    //这里是跟创建的对象匹配
    @Results
        ({@Result(property = "templates", column = "templates"),
          @Result(property = "password",column = "password")
    })
    UserName findUserByName(@Param("telephone") String telephone);

    /**
    * 查询用户名和密码用于登录
    * */
    @Select(value="select * from tt_user u where u.telephone = #{telephone} and password = #{password}")
    UserName findUserPhone(UserName userName);


    /**
    * 查询密码是否正确
    * */
    @Select(value="select u.password from tt_user u where u.password=#{password}")
    //这里是跟创建的对象匹配
    @Results
            ({@Result(property = "password", column = "password")})
    UserName findUserPassword(@Param("password") String password);
}
