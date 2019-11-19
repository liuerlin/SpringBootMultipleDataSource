package com.doublesource.demo.dataSource_2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Goods {
    private  String  id;
    private  String  goodsName;
    private  Double  price;
}
