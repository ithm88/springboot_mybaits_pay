package com.item.mapper;

import com.item.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WxAppletsMapper {

    /*
    * 查询所有轮播图的数据
    * */
    @Select(value = "select * from swiperlist")
    List<SwiperList> findSwiperList();

    /*
    * 查询所有列表数据
    * */
    @Select(value = "select * from yg_category_url")
    List<YgCategoryUrl> categoryUrlFindAll();

    List<FloorTitle> findCategoryAll();

    List<FloorProductList> findFloorProductList();

    @Select(value = "SELECT * FROM sp_category WHERE cat_pid = 0")
    List<YgCategoryList> categoryFindAll();
}
