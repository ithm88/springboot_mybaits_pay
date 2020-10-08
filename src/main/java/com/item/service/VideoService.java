package com.item.service;

import com.item.bean.OrderPayAll;
import com.item.bean.OrderSuccess;
import com.item.bean.Video;
import com.item.bean.VideoImg;
import com.item.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoMapper videoMapper;

    public List<Video> findAllVideo() {
        return videoMapper.findVideo();
    }

    public Video findBuId(String vid) {
        return videoMapper.findById(vid);
    }

    public List<VideoImg> findBuUrlImg() {
        return videoMapper.findVideoImg();
    }

    public List<VideoImg> findAction() {
        return videoMapper.findAction();
    }

    public List<OrderPayAll> orderPayAll(String telephone) {
        return videoMapper.orderPayAll(telephone);
    }

    public void insertAll(String orderNo, String body, String price, String telephone) {
        //到这里先去查询数据库里面根据手机号查询
       Integer telephoneId = videoMapper.selectTelephone(telephone);
        System.out.println("业务层service 打印获取到dao层的"+telephoneId);
       if(telephoneId != null){
           System.out.println(orderNo);
           System.out.println(body);
           System.out.println(price);
           System.out.println(telephoneId);
           //再把手机号的id存进去
           videoMapper.insertAll(orderNo,body,price,telephoneId);
       }
    }

    public void updateOrder(String trade_state,String telephone,String orderNo) {
        videoMapper.updateOrder(trade_state,telephone,orderNo);
    }
}
