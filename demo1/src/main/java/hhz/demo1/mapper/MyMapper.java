package hhz.demo1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: MyMapper
 * @Description:
 * @Author: huanghz
 * @Date: 2020/6/28 9:22
 */
@Mapper
public interface MyMapper {
    @Select("select count(*) from user")
    int count();
}
