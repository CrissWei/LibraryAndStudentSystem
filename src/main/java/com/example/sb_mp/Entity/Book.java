package com.example.sb_mp.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;


}
