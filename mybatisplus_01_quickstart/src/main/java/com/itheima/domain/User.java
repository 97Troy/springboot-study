package com.itheima.domain;

import lombok.Data;
import lombok.Setter;

//lombok
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String tel;


}
