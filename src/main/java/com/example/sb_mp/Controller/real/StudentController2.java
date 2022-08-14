package com.example.sb_mp.Controller.real;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.sb_mp.Entity.Student;
import com.example.sb_mp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * @Date 2022/8/14
 * 使用Postman可以完全实现这些操作，我自己成功了
 *
 */
//@RestController //为了测试，暂时先废弃掉
@RequestMapping("/students")
public class StudentController2 {
    @Autowired
    private IStudentService service;

    /**
     * 查询是get请求
     * 成功查询全部结果
     * http://localhost/students
     */
    @GetMapping
    public List<Student> getAll(){
        return service.list();
    }

    /**
     * 这个是post请求
     * @RequestBody 是请求体参数
     *http://localhost/students
     * 使用json格式，post传入到数据库
     * {   "id":"66",
     *     "name":"李丽",
     *     "age":"24",
     *     "sex":"女",
     *     "address":"北京",
     *     "math":"99",
     *     "english":"98"
     * }
     */
    @PostMapping
    public boolean save(@RequestBody Student student){
        return service.save(student);
    }


    /**
     * {   //修改id为10 的数据
     *     "id":"10",
     *     "name":"李丽",
     *     "age":"24",
     *     "sex":"女",
     *     "address":"北京",
     *     "math":"99",
     *     "english":"98"
     * }
     */
    @PutMapping
    public boolean update(@RequestBody Student student){
        return service.updateStudent(student);
    }

    /**
     * deleteStudent方法是我自定义的
     * @DeleteMapping 有必要了解一下
     * @PathVariable 是请求体参数
     */
    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return service.deleteStudent(id);
    }

    /**删除id是15的数据
     * http://localhost/students/15
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Student getByID(@PathVariable Integer id){
        return service.getById(id);
    }

    /**
     * 分页操作
     */
    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Student> getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        return service.getPage(currentPage,pageSize);
    }
}
