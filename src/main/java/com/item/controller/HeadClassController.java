package com.item.controller;
import com.item.bean.Student;
import com.item.mapper.StudentAllMapper;
import com.item.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class HeadClassController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentAllMapper studentAllMapper;

    @RequestMapping(value = "/info",method = RequestMethod.GET,produces = {"application/json"})
    public List<Student> getStudentInfo(){
        System.out.println("info进来了");
         List<Student> students = studentMapper.selectStudentCourse();
        return students;
        //return new DataResponseVo(0,studentMapper.selectStudentCourse());
    }
    @RequestMapping(value = "/linktable",method = RequestMethod.GET,produces = {"application/json"})
    public List getlinkTableSel(@RequestParam(value = "id",required = true) Integer id){
        System.out.println("linktable进来了");
        List list = studentAllMapper.linkTableSel(id);
        return list;
        //return new DataResponseVo(0,studentAllMapper.linkTableSel(id));
    }
}
