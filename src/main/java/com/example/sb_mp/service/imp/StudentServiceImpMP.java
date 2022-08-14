package com.example.sb_mp.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb_mp.Dao.StudentDao;
import com.example.sb_mp.Entity.Student;
import com.example.sb_mp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个是MP自带的一些最基本的CRUD方法，简化开发
 * @Date 2022/8/13
 * @Author 张维
 */

@Service
public class StudentServiceImpMP extends ServiceImpl<StudentDao, Student> implements IStudentService {

    /**
     * 如果MyBatisPlus自带的CRUD方法不够，那就跟用MyBatis一样手动添加自己的方法
     */


    @Autowired
    private StudentDao studentDao;


    @Override
    public Boolean updateStudent(Student student) {
        return studentDao.updateById(student)>0;
    }

    @Override
    public Boolean insertStudent(Student student) {
        return studentDao.insert(student)>0;
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        return studentDao.deleteById(id)>0;
    }

    /**
     * 自定义的分页操作
     * @param currentPage 当前页
     * @param pageSize 每页的条数
     * @return
     */
    @Override
    public IPage<Student> getPage(Integer currentPage, Integer pageSize) {
       IPage<Student> page = new Page<>(currentPage,pageSize);
       return studentDao.selectPage(page,null);
    }

}
