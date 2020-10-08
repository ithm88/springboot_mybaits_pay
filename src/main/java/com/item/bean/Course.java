package com.item.bean;

import java.util.List;
//课程实体
public class Course {
    private Integer id;
    private String name;
    private Integer credit;
    private List<Student> students; //多对多

    public Course() {
    }

    public Course(Integer id, String name, Integer credit, List<Student> students) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}