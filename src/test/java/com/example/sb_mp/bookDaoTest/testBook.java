package com.example.sb_mp.bookDaoTest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sb_mp.Dao.BookDao;
import com.example.sb_mp.Entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testBook {

    @Autowired
    private BookDao bookDao;

    /**
     * 根据ID查询。自己写的方法
     * select * from book where id = #{id}
     */
    @Test
    void test1getByID() {
        System.out.println(bookDao.getByID(2));
    }


    /**
     * 查询全部，select * from book;
     * 不过是我自己手动写的，不是MP自带的功能
     */
    @Test
    void test2getAll() {
        System.out.println(bookDao.getAll());
    }


    @Test
    void test3getByName() {
        System.out.println(bookDao.getByName("计算机"));
    }

    /**
     * 添加一个学生数据
     */
    @Test
    void test4Save() {
        Book s = new Book(10,"计算机","操作系统","清华出版社");
        System.out.println(bookDao.insert(s));
    }

    @Test
    void test5Save2() {
        Book s = new Book(66,"计算机","linux系统","清华出版社");
        System.out.println(bookDao.insert(s));
    }

    /**
     * 删除id为6的学生
     */
    @Test
    void test6() {
        System.out.println(bookDao.deleteById(6));
    }

    /**
     * 查询全部，select * from student;
     * 没有设置条件，参数是null
     */
    @Test
    void test7() {
        System.out.println(bookDao.selectList(null));
    }

    /**
     *不知道怎么更新  【原因：其实是表的id没有auto自增】
     */
    @Test
    void test8() {
        Book s = new Book();
        s.setId(10);
        System.out.println(bookDao.updateById(s));
    }


    /**
     * 分页查询
     * SELECT id,name,age,sex,address,math,english FROM student LIMIT 1,5;
     */
    @Test
    void test9() {
        IPage page = new Page(1,5);
        bookDao.selectPage(page,null);
        //System.out.println(page.getRecords());

    }

    /**
     * 条件查询where,like
     * select * from student where name like %马% and age>38;
     */
    @Test
    void test10() { //成功
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","数据"); //like %数据%
        qw.gt("id","2");//id>2的数据
        bookDao.selectList(qw);
    }

    @Test
    void test11() { //成功
        String type = "计算机";
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("type",type); //查询'计算机'类型的书籍
        bookDao.selectList(qw);
    }

    /**
     * 为什么这个test11不行呢。前面的test10可以
     */
    @Test
    void test12() {
        String type = "计算机";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //lqw.like(name!=null,Book::getName,"数据");
        lqw.like(Book::getType,type);
        bookDao.selectList(lqw);
    }




}
