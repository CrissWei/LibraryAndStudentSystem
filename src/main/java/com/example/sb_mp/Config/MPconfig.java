package com.example.sb_mp.Config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:张维Cris
 * @Date:2022/8/13
 *
 * MP的拦截器，固定格式。不用去记代码
 * 作用是用来做查询分页的,select * from student limit 1,5;
 * 其实就是可以帮助动态拼接limit 语句
 */
@Configuration
public class MPconfig {
    @Bean
    public MybatisPlusInterceptor myInterceptor(){
       MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
       interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
       return interceptor;
    }
}
