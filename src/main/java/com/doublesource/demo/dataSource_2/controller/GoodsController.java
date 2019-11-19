package com.doublesource.demo.dataSource_2.controller;


import com.doublesource.demo.dataSource_2.entity.Goods;
import com.doublesource.demo.dataSource_2.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    @RequestMapping("/getAllGoods")
    public List index(){
        List<Goods> goodsList = goodsMapper.getAllGoods();
        return goodsList;
    }
}