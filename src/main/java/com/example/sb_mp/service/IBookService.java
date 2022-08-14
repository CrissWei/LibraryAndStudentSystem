package com.example.sb_mp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sb_mp.Entity.Book;

public interface IBookService extends IService<Book> {
    //自己根据实际需求添加的方法，而不是MyBatisPlus自带的最基本的CRUD
    Boolean updateBook(Book book);
    Boolean insertBook(Book book);
    Boolean deleteBook(Integer id );

    /**
     * 自定义一个分页操作
     */
    IPage<Book> getPage(Integer currentPage, Integer pageSize);


}
