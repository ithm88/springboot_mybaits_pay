package com.item.service;

import com.item.bean.*;
import com.item.mapper.WxAppletsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxAppletsService {

    @Autowired
    WxAppletsMapper wxAppletsMapper;


    public List<SwiperList> findSwiperList() {
        return wxAppletsMapper.findSwiperList();
    }

    public List<YgCategoryUrl> categoryUrlFindAll() {
        return wxAppletsMapper.categoryUrlFindAll();
    }

    public List<FloorTitle> findCategoryFloorList() {
        //首先查询数据库的第一个表,然后根据第一个表返回的对象获取里面的id进行第二次查询封装对象
        List<FloorTitle> floorTitles = wxAppletsMapper.findCategoryAll();
        return floorTitles;
    }

    public List<FloorProductList> findFloorProductList() {
        List<FloorProductList> floorProductLists = wxAppletsMapper.findFloorProductList();
        return floorProductLists;
    }

    public List<YgCategoryList> categoryFindAll() {
        return wxAppletsMapper.categoryFindAll();
    }
}
