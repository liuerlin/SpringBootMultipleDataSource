package com.doublesource.demo.dataSource_2.mapper;

import com.doublesource.demo.dataSource_2.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * 元信息表CRUD
 * @author liuerlin 2019-06-04 18:02
 */
@Component
@Mapper
public interface GoodsMapper {
    List<Goods> getAllGoods();
}
