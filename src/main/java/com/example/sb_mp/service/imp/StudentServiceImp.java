package com.example.sb_mp.service.imp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sb_mp.Dao.StudentDao;
import com.example.sb_mp.Entity.Student;
import com.example.sb_mp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 为什么是boolean?  因为是看是不是>0，表示执行成功的sql语句数量
     * @param student
     * @return
     */
    @Override
    public boolean insert(Student student) {
        return studentDao.insert(student)>0;
    }

    @Override
    public boolean update(Student student) {
        return studentDao.updateById(student)>0;
    }

    @Override
    public boolean deleteByID(Integer id) {
        return studentDao.deleteById(id)>0;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Student selectByID(Integer id) {
        return studentDao.selectById(id);
    }

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<Student> selectAll() {
        return studentDao.selectList(null);
    }

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页条数
     * @return 分页查询结果
     */
    @Override
    public IPage<Student> getPage(Integer currentPage, Integer pageSize) {
        IPage<Student> page = new Page<>(currentPage,pageSize);
        return studentDao.selectPage(page,null);
    }

}
