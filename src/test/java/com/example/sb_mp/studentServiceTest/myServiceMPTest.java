package com.example.sb_mp.studentServiceTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.sb_mp.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 本节测试基本全部通过（不知道update）,专门测试MyBatisPlus自带的CRUD
 * @Date 2022/8/13
 * @Author 张维
 */
@SpringBootTest
public class myServiceMPTest {

    @Autowired
    private IStudentService studentService;

    /**
     * 根据id查询
     */
    @Test
    public void test1(){
        System.out.println(studentService.getById(2));
    }

    /**
     * 查询全部
     */
    @Test
    public void test2(){
        System.out.println(studentService.getMap(null));
    }
    /**
     * 查询全部
     */
    @Test
    public void test3(){
        System.out.println(studentService.list());
    }


    /**
     * 删除77
     */
    @Test
    public void test4(){
        System.out.println(studentService.removeById(77));
    }


    /**
     * 不知道怎么修改
     */
    @Test
    public void test5(){
        System.out.println(studentService.update());
    }

    /**
     * 分页查询,1-5页
     */
    @Test
    public void test6(){
        IPage page = new Page(1,5);
        System.out.println(studentService.page(page));


        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    /**
     * 测试自己的删除方法, 成功！
     */

    @Test
    public void test7(){
        System.out.println(studentService.deleteStudent(98));
    }
}
