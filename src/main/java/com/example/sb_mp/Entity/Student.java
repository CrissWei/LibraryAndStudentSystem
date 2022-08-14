package com.example.sb_mp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Integer math;
    private Integer english;

}
