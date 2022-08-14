package com.example.sb_mp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sb_mp.Entity.Student;

public interface IStudentService extends IService<Student> {
    //自己根据实际需求添加的方法，而不是MyBatisPlus自带的最基本的CRUD
    Boolean updateStudent(Student student);
    Boolean insertStudent(Student student);
    Boolean deleteStudent(Integer id );

    /**
     * 自定义一个分页操作
     */
    IPage<Student> getPage(Integer currentPage, Integer pageSize);


}
