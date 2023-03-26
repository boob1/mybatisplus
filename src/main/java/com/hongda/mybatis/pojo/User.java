package com.hongda.mybatis.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;

    private String userName;

    private Integer age;

    private String email;



}
