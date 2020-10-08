package com.item.bean;

import java.util.List;

public class HeadClass {
    private Integer cid;
    private String cname;
    private HeadTecher headTecher;//用于一对一

    private List<Student> students;//用于一对多

    public HeadClass() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public HeadTecher getHeadTecher() {
        return headTecher;
    }

    public void setHeadTecher(HeadTecher headTecher) {
        this.headTecher = headTecher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
