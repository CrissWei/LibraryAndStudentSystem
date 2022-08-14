package com.example.sb_mp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.sb_mp.Entity.Student;


import java.util.List;


public interface StudentService {
    boolean insert(Student student);
    boolean update(Student student);
    boolean deleteByID(Integer id);
    Student selectByID(Integer id);
    List<Student> selectAll();//查询所有
    //分页查询,param当前页码和每页显示的条数
    IPage<Student> getPage(Integer currentPage,Integer pageSize);
}
