package com.item.controller;

import com.item.bean.*;
import com.item.service.WxAppletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WxAppletsController {

    @Autowired
    WxAppletsService wxAppletsService;


    /*
    * 查询首页所有的轮播图
    * */
    @RequestMapping("/swiperList")
    @ResponseBody
    public List<SwiperList> swiperList(){
        System.out.println("查询轮播图数据进来了");
        //查询所有轮播图数据
        List<SwiperList> swiperLists = wxAppletsService.findSwiperList();
        System.out.println(swiperLists);
        return swiperLists;
    }

    /*
    * 查询首页分类的列表
    * */
    @RequestMapping("/categoryList")
    @ResponseBody
    public List<YgCategoryUrl> categoryUrlFindAll(){
        //调用服务层的方法来查询分类信息
        List<YgCategoryUrl> ygCategoryUrlList = wxAppletsService.categoryUrlFindAll();
        System.out.println(ygCategoryUrlList);
        return ygCategoryUrlList;
    }

    /*
    * 查询floor_title 多表分类
    * */
    @RequestMapping("/floorTitleList")
    @ResponseBody
    public List<FloorTitle> findCategoryFloorList(){

        //查询集合
        List<FloorTitle> categoryFloorLists = wxAppletsService.findCategoryFloorList();
        System.out.println(categoryFloorLists);
        return categoryFloorLists;
    }

    /*
    * 查询一个集合
    * */
    @RequestMapping("/floorProductList")
    @ResponseBody
    public List<FloorProductList> findFloorProductList(){
        //多对多查询一个对象和一个集合
        List<FloorProductList> floorProductLists = wxAppletsService.findFloorProductList();
        System.out.println(floorProductLists);
        return floorProductLists;
    }

    /*
    * 查询所有大家电
    * */
    @RequestMapping("/categoryPid")
    @ResponseBody
    public List<YgCategoryList> categoryFindAll(){
        //查询所有的大家电
        List<YgCategoryList> ygCategoryLists = wxAppletsService.categoryFindAll();
        System.out.println(ygCategoryLists);
        return ygCategoryLists;
    }
}
