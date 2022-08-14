package com.example.sb_mp.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_mp.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * extends BaseMapper<Student> 里面有很多自带的CRUD
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {
    @Select("select * from student where id = #{id}")
    Student getByID(Integer id);


    //【成功】找到了数据
    @Select("select * from student where id = #{id}")
//#{id}是形参
    Student getById(Integer id);

    //自己再测试一个方法试试 【失败】 ---> List<Book> 【成功】
    @Select("select * from student")
    List<Student> getAll();// 如果是public Book getAll();【失败】

    //【成功】找到数据
    @Select("select * from student where name = #{name}")
//#{name}是下面的形参
    Student getByName(String name);

    //查>=id的数据【失败】 --- >【成功】
    @Select("select * from student where id >=#{id}")
    List<Student> getBigId(Integer id);


    @Select("select * from student where age >=#{age}")
    List<Student> getBigAge(Integer age);
}
