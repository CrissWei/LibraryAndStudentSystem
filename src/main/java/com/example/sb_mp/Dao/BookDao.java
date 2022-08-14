package com.example.sb_mp.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_mp.Entity.Book;
import com.example.sb_mp.Entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * extends BaseMapper<Book> 里面有很多自带的CRUD
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
    @Select("select * from book where id = #{id}")
    Book getByID(Integer id);


    //【成功】找到了数据
    @Select("select * from book where id = #{id}")
//#{id}是形参
    Book getById(Integer id);

    //自己再测试一个方法试试 【失败】 ---> List<Book> 【成功】
    @Select("select * from book")
    List<Book> getAll();// 如果是public Book getAll();【失败】

    //【成功】找到数据
    @Select("select * from book where name = #{name}")
//#{name}是下面的形参
    Book getByName(String name);

    //查>=id的数据【失败】 --- >【成功】
    @Select("select * from book where id >=#{id}")
    List<Book> getBigId(Integer id);


    @Select("select * from book where age >=#{age}")
    List<Book> getBigAge(Integer age);
}
