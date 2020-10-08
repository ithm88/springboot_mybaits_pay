package com.item.service;

import com.item.bean.Person;
import com.item.bean.Users;
import com.item.mapper.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    //添加关联
    @Autowired
    PersonDao PersonDao;

    /*
    * Service 层介于controller 和dao之间作为服务层进行一些逻辑处理
    * 这里逻辑太简单,所以只是单纯调用到,所有不用注释
    * */
    public List<Users> getAll(){
        //返回PersonDao.getAll(),查到的数据,封装到Person对象中返回,对象又存在一个集合里面
        return PersonDao.getAll();
    }

    /*
    * 根据id查询的意思
    * */
    public Person getPersonById(int id){
        //根据id查询,传入一个id,返回一个person对象
        return PersonDao.getPersonByID(id);
    }

    /*
    * 根据id删除
    * */
    public void delete(int id){
        //根据id删除对象,没有返回值
        PersonDao.delete(id);
    }

    /*
    * 增加数据
    * */
    public Users insert(Users user) {
        PersonDao.insert(user);
        System.out.println("服务端拿到"+user);
        return user;
    }

    /*
    * 修改数据
    * */
    public int update(Users user) {
        System.out.println("服务端拿到修改的数据"+user);
        return PersonDao.update(user);
    }
}
