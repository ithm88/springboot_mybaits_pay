package com.item.controller;

import com.item.bean.Result;
import com.item.bean.Users;
import com.item.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    //设置访问路由值为路径
    /*
    * 查询所有
    * */
    @RequestMapping("/findAllUsers")
    @ResponseBody
    //public ModelAndView index(){
    public List<Users> index(){
//        //顾明司仪,实体和数据,同时返回页面模板和数据
//        ModelAndView mav = new ModelAndView("index");
//        List<Person> list = personService.getAll();
//        mav.addObject("list",list);
//        System.out.println(list); //打印测试是否拿到了list
        List<Users> listUser = personService.getAll();
        System.out.println(listUser);
        return listUser;
    }

    /*
    * 根据传过来的id删除
    * */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        //try{
            System.out.println(id);
            System.out.println("进来了");
            personService.delete(id);
            //如果成功了就不会报错,我们就返回值
            return new Result(true,"成功了");
//        }catch(Exception e){
//            e.printStackTrace();
//            return new Result(false,"出现异常");
//        }
    }

    /*
    * 增加功能
    * */
    @RequestMapping("/insert")
    @ResponseBody
    public Users insert(Users user){
        System.out.println("前端传来的"+user);
       return personService.insert(user);
    }

    /*
    * 修改功能
    * */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Users user){
        System.out.println("拿到客户端的修改数据"+user);
        //修改成功使用int类型接收
        int result = personService.update(user);
       if(result >= 1){
           return "修改成功";
       }else{
           return "修改失败";
       }
    }


}
