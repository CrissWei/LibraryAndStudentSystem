package com.example.sb_mp.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sb_mp.Dao.BookDao;
import com.example.sb_mp.Entity.Book;
import com.example.sb_mp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这个是MP自带的一些最基本的CRUD方法，简化开发
 *
 * @Date 2022/8/13
 * @Author 张维
 */

@Service
public class BookServiceImpMP extends ServiceImpl<BookDao, Book> implements IBookService {

    /**
     * 如果MyBatisPlus自带的CRUD方法不够，那就跟用MyBatis一样手动添加自己的方法
     */


    @Autowired
    private BookDao bookDao;


    @Override
    public Boolean updateBook(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean insertBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean deleteBook(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    /**
     * 自定义的分页操作
     *
     * @param currentPage 当前页
     * @param pageSize    每页的条数
     * @return
     */
    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        return bookDao.selectPage(page, null);
    }

    //@Override 【不知道为什么使用 LambdaQueryWrapper<Book> 会报错】
//    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book queryBook) {
//        IPage page = new Page(currentPage, pageSize);
//        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        lqw.like(Strings.isNotEmpty(queryBook.getName()), Book::getName, queryBook.getName());
//        lqw.like(Strings.isNotEmpty(queryBook.getType()), Book::getType, queryBook.getType());
//        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),
//                Book::getDescription, queryBook.getDescription());
//        return bookDao.selectPage(page, lqw);
//    }
    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize, Book book) {
        //不知道为什么使用 LambdaQueryWrapper<Book> 会报错，所以这个我使用QueryWrapper
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("type",book.getType());
        qw.like("name",book.getName());
        qw.like("description",book.getDescription());
        IPage page = new Page(currentPage, pageSize);
        return bookDao.selectPage(page, qw);
    }

}
