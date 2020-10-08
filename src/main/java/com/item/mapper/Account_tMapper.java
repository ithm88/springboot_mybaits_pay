package com.item.mapper;

import com.item.bean.Account_t;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Account_tMapper {

    /*
    * 根据aid 查询账号信息
    * param uid
    * return
    * */
    @Select("select * from account where uid=#{uid}")
    List<Account_t> findAccountByAid(int uid);

}
