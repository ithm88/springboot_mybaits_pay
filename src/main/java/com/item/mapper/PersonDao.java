package com.item.mapper;

import com.item.bean.Person;
import com.item.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
//@Repository
public interface PersonDao {
    /*
    * 查所有
    * return List<Person>
    * */
    List<Users> getAll();

    /*
    * 根据id查询
    * id 要查询人员的id
    * */
    Person getPersonByID(int id);

    /*
    * 删除
    * id 要删除人员的id
    * */
    void delete(int id);

    /*
    * 更新
    * 要更新的Person实例
    * */
    int update(Users user);

    /*
    * 增加
    * 要新增的Person实例
    * */
    void newp(Users user);

    void insert(Users user);

}
