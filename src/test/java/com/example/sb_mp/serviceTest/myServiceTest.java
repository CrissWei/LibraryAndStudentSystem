package com.example.sb_mp.serviceTest;

import com.example.sb_mp.Entity.Student;
import com.example.sb_mp.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class myServiceTest {

    @Autowired
    private StudentService studentService;

    /**
     * 根据id查询
     */
    @Test
    public void test1(){
        System.out.println(studentService.selectByID(2));
    }

    /**
     * 查询全部
     */
    @Test
    public void test2(){
        System.out.println(studentService.selectAll());
    }

    /**
     * 删除
     */
    @Test
    public void test3(){
        System.out.println(studentService.deleteByID(77));
    }

    /**
     * 增加数据，有点问题，id自增好像有点问题，没办法自增。但是配置了auto
     */
    @Test
    public void test4(){
        Student s = new Student();
        s.setId(25);
        s.setName("王思聪");
        s.setAge(25);
        s.setSex("男");
        s.setAddress("四川");
        s.setMath(99);
        s.setEnglish(100);
        System.out.println(studentService.insert(s));
    }

    /**
     * 不知道怎么修改
     */
    @Test
    public void test5(){
        Student s = new Student();
        s.setId(16);
        System.out.println(studentService.update(s));
    }

    /**
     * 分页查询,1-5页
     */
    @Test
    public void test6(){
        System.out.println(studentService.getPage(1,5));

    }

}
