package com.example.sb_mp.Controller.exception;

import com.example.sb_mp.Controller.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 张维
 * @Date 2022/8/14
 * 手动定义web的异常处理
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class) //拦截所有的异常，也可以分多钟异常去反馈给用户不同的提示
    public Result allMyException(Exception e){
        //记录日志
        //通知运维
        //通知开发

        //打印错误信息
        e.printStackTrace();
        return new Result(500,"服务器故障，请稍后再试！");
        /**
         * 可以在postman里面看到，
         * 如：把更新操作的put请求改成delete或者其他的请求就会报错，信息如下：
         * {
         *     "flag": false,
         *     "data": null,
         *     "statusCode": 500,
         *     "mes": "服务器故障，请稍后再试！"
         * }
         */

    }
}
