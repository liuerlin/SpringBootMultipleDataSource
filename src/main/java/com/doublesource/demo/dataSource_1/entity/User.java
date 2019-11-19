package com.doublesource.demo.dataSource_1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class User {
    private  String  id;
    private  String  userName;
    private  String  password;
}
