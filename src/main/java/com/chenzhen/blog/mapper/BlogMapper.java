package com.chenzhen.blog.mapper;
import com.chenzhen.blog.entity.vo.BlogVO;
import org.apache.ibatis.annotations.Param;

import com.chenzhen.blog.entity.pojo.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author MIS
* @description 针对表【t_blog】的数据库操作Mapper
* @createDate 2022-09-11 18:21:11
* @Entity com.chenzhen.blog.pojo.Blog
*/
@Mapper
public interface BlogMapper extends BaseMapper<Blog> {


    List<BlogVO> getRecommendList();

    int updateViews(Long blogId);

    int updateCommentCount(Long blogId);

    Long countViews();

    String getTitleById(@Param("id") Long id);

    List<BlogVO> pageAdminBlogs();

    Boolean saveBlogTags(@Param("blogId") Long id,@Param("tagIds") List<Long> tagIds);

    BlogVO getBlogVO(Long id);

    List<Long> getBlogIdsByTagIds(@Param("tagIds") long[] tagIds);

    Boolean deleteAllBlogTags(@Param("blogId")Long blogId);

    List<BlogVO> pageBlogs();

    List<BlogVO> getBlogListByBlogIds(@Param("blogIds") List<Long> blogIds);

    List<BlogVO> getBlogList();

    List<Blog> getAllTitle();
}




