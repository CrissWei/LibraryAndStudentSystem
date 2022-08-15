package com.example.sb_mp.studentDaoTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sb_mp.Dao.StudentDao;
import com.example.sb_mp.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbMpApplicationTests {

    @Autowired
    private StudentDao studentDao;

    /**
     * 根据ID查询。自己写的方法
     * select * from student where id = #{id}
     */
    @Test
    void test1getByID() {
        System.out.println(studentDao.getByID(2));
    }


    /**
     * 查询全部，select * from student;
     * 不过是我自己手动写的，不是MP自带的功能
     */
    @Test
    void test2getAll() {
        System.out.println(studentDao.getAll());
    }


    @Test
    void test3getByName() {
        System.out.println(studentDao.getByName("马化腾"));
    }

    /**
     * 添加一个学生数据
     */
    @Test
    void test4Save() {
        Student s = new Student(10,"李四",44,"男","北京",98,99);
        System.out.println(studentDao.insert(s));
    }

    @Test
    void test5Save2() {
        Student s = new Student(66,"老六2",66,"男","北京",98,99);
        System.out.println(studentDao.insert(s));
    }

    /**
     * 删除id为23的学生
     */
    @Test
    void test6() {
        System.out.println(studentDao.deleteById(66));
    }

    /**
     * 查询全部，select * from student;
     * 没有设置条件，参数是null
     */
    @Test
    void test7() {
        System.out.println(studentDao.selectList(null));
    }

    /**
     *不知道怎么更新
     */
    @Test
    void test8() {
        Student s = new Student();
        s.setId(10);
        System.out.println(studentDao.updateById(s));
    }


    /**
     * 分页查询
     * SELECT id,name,age,sex,address,math,english FROM student LIMIT 1,5;
     */
    @Test
    void test9() {
        IPage page = new Page(1,5);
        studentDao.selectPage(page,null);
        //System.out.println(page.getRecords());

    }

    /**
     * 条件查询where,like
     * select * from student where name like %马% and age>38;
     */
    @Test
    void test10() {
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.like("name","马"); //like %马%
        qw.gt("age","38"); //age>38不是>=, gt: greater then
        studentDao.selectList(qw);
    }

    /**
     * 为什么这个test11不行呢。前面的test10可以
     */
    @Test
    void test11() {
        String name = "马";
        LambdaQueryWrapper<Student> lqw = new LambdaQueryWrapper<>();
        lqw.like(name!=null,Student::getName,"马");//查询‘马’
        studentDao.selectList(lqw);
    }




}
