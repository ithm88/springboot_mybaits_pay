package com.item.controller;

import com.item.bean.OrderPayAll;
import com.item.bean.OrderSuccess;
import com.item.bean.Video;
import com.item.bean.VideoImg;
import com.item.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideoController {

    @Autowired
    VideoService videoService;

    /*
    * 查询所有
    * */
    @RequestMapping("/video")
    @ResponseBody
    public List<Video> findAll(){
        List<Video> allVideo = videoService.findAllVideo();
        return allVideo;
    }

    /*
    * 根据id查询
    * */
    @RequestMapping("/videoById")
    @ResponseBody
    public Video findById(String vid){ //@PathVariable Integer id,
       System.out.println("数据进来了"+vid);
       Video videoId = videoService.findBuId(vid);
       return videoId;
    }

    /*
    * 查询封面的所有连接以及id
    * */
    @RequestMapping("/videoImgUrl")
    @ResponseBody
    public List<VideoImg> findImgAll(){
        System.out.println("请求图片的url进来了");
        List<VideoImg> videoImg = videoService.findBuUrlImg();
        System.out.println(videoImg);
        return videoImg;
    }

    /*
    * 精选推荐渲染页面
    * */
    @RequestMapping("/videoaction")
    @ResponseBody
    public List<VideoImg> findAction(){
        System.out.println("精选进来了");
        List<VideoImg> vdewoAction = videoService.findAction();
        return vdewoAction;
    }

    /*
    * 根据前端传过来额手机号查询用户的所有信息,两个表的
    * */
    @RequestMapping("/payOrderAll")
    @ResponseBody
    public List<OrderPayAll> orderPayAll(String telephone){
        System.out.println(telephone);
        //调用service层的方法查询当前用户的会员信息
        List<OrderPayAll> orderPayAll = videoService.orderPayAll(telephone);
        return orderPayAll;
    }

    /*
    * 支付成功修改订单的状态
    * */
    @RequestMapping("/updateOrder")
    @ResponseBody
    public String updateOrder(String trade_state,String telephone,String orderNo){
        //打印是否拿到了数据
        System.out.println(trade_state);
        System.out.println(telephone);
        System.out.println(orderNo);
        //创建一个对象接收
        OrderSuccess orderSuccess = new OrderSuccess();
        orderSuccess.setTrade_state(trade_state);
        orderSuccess.setTelephone(telephone);
        orderSuccess.setOrderNo(orderNo);
        videoService.updateOrder(trade_state,telephone,orderNo);

        return "支付状态已经成功修改了";
    }
}
