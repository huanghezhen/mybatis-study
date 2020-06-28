package hhz.demo2.mapper;


import hhz.demo2.model.Blog;

/**
 * @ClassName: BlogMapper
 * @Description:
 * @Author: huanghz
 * @Date: 2020/5/26 16:18
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
