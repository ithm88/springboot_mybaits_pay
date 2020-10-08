package com.item.mapper;

import com.item.bean.OrderPayAll;
import com.item.bean.Video;
import com.item.bean.VideoImg;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper {

    @Select(value = "select * from video")
    List<Video> findVideo();

    @Select(value = "select * from video where id = #{vid}")
    Video findById(String vid);

    @Select(value="select * from videoimg  limit 4")
    List<VideoImg> findVideoImg();

    @Select(value="select * from videoimg limit 5 , 10")
    List<VideoImg> findAction();

    @Select(value="select p.id_p ,u.telephone ,p.orderNo ,p.body ,p.price ,p.trade_state ,p.pid from tt_user u ,payorder p where u.id = p.pid and u.telephone = #{telephone}")
    List<OrderPayAll> orderPayAll(String telephone);

    //@Insert(value="insert into payorder values(null,#{orderNo},#{body},#{price},null,#{telephoneId})")
    //加入
    @Options(useGeneratedKeys = true,keyProperty = "id", keyColumn = "id")
    @Insert(value="insert into payorder values(null,#{orderNo},#{body},#{price},\"noPay\",#{telephoneId})")
    void insertAll(@Param("orderNo")String orderNo, @Param("body")String body, @Param("price")String price, @Param("telephoneId")Integer telephoneId);

    @Select(value="select id from tt_user where telephone = #{telephone}")
    Integer selectTelephone(String telephone);

    @Update(value="update tt_user u,payorder p set trade_state = #{trade_state} where u.id = p.pid and u.telephone = #{telephone} and p.orderNo = #{orderNo}")
    void updateOrder(@Param("trade_state")String trade_state, @Param("telephone")String telephone, @Param("orderNo")String orderNo);
    //void updateOrder(String telephone, String orderNo, String trade_state);
    //void updateOrder(@Param("telephone")String telephone, @Param("orderNo")String orderNo, @Param("trade_state")String trade_state);
}
