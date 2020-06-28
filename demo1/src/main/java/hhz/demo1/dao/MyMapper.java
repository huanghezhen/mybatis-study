package hhz.demo1.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: MyMapper
 * @Description:
 * @Author: huanghz
 * @Date: 2020/6/28 14:36
 */
@Mapper
public interface MyMapper {
    int count();
}
