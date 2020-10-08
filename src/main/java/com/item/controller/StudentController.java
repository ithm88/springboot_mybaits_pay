package com.item.controller;

import com.item.bean.HeadClass;
import com.item.bean.HeadTecher;
import com.item.mapper.HeadClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private HeadClassMapper headClassMapper;
    @RequestMapping(value = "/classInfo",method = RequestMethod.GET,produces = {"application/json"})
    public HeadClass getClassInfo(@RequestParam(value = "id",required = true) Integer id){
        System.out.println("classInfo 进来了");
        HeadClass headClass = headClassMapper.selectClassById(id);
        return headClass;
        //return new DataResponseVo(0,headClassMapper.selectClassById(id));
    }

    @RequestMapping(value = "/getTecherinfo",method = RequestMethod.GET,produces = {"application/json"})
    public List<HeadTecher> getHeadTecher(){
        System.out.println("getTecherinfo 进来了");
        List<HeadTecher> headTecher = headClassMapper.getHeadTecher();
        return headTecher;
        //return new DataResponseVo(0,headClassMapper.getHeadTecher());
    }
    @RequestMapping(value = "/getclassandstudent",method = RequestMethod.GET,produces = {"application/json"})
    public List<HeadClass> getClassAndStudent(@RequestParam(value = "id",required = true) Integer id){
        System.out.println("getclassandstudent 进来了");
        List<HeadClass> headClasses = headClassMapper.selectClassAndStudentById(id);
        return headClasses;
        //return new DataResponseVo(0,headClassMapper.selectClassAndStudentById(id));
    }
}
