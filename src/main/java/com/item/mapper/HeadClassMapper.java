package com.item.mapper;

import com.item.bean.HeadClass;
import com.item.bean.HeadTecher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HeadClassMapper {

    HeadClass selectClassById(@Param("id") Integer id);

    List<HeadTecher> getHeadTecher();

    List<HeadClass> selectClassAndStudentById(@Param("id") Integer id);
}
