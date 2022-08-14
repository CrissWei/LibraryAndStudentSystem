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
    //private Integer code;//状态码，例如404是找不到url,500是服务器故障,200是成功


    public Result(boolean flag) {
        this.flag = flag;
    }

}
