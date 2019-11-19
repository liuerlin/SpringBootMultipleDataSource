package com.doublesource.demo.dataSource_1.mapper;

import com.doublesource.demo.dataSource_1.entity.User;
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
public interface UserMapper {
    List<User> getAllUser();
}
