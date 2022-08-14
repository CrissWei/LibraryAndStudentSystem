package com.example.sb_mp.Controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<E> {
    private boolean flag;
    private E data;
    private Integer statusCode;//状态码，例如404是找不到url,500是服务器故障,200是成功
    private E mes; //出错后，告诉用户的消息

    public Result(boolean flag) {
        this.flag = flag;
    }

    //E data， 也可以代表是E mes，反正是泛型，可以传数据data，也可以给用户传消息message
    public Result(boolean flag, E data) {
        this.flag = flag;
        this.data = data;
    }

/*    public Result(E mes, boolean flag) {
        this.flag = flag;
        this.mes = mes;
    }*/


    public Result(Integer statusCode, E mes) {
        this.statusCode = statusCode;
        this.mes = mes;
    }

    public Result(E mes) {
        this.mes = mes;
    }

    public Result(boolean flag, Integer statusCode, E mes) {
        this.flag = flag;
        this.statusCode = statusCode;
        this.mes = mes;
    }

}
