package com.management.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.Subject;
import com.management.domain.query.SubjectQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author rui_t
 * @description 针对表【subject】的数据库操作Mapper
 * @createDate 2022-08-08 15:56:37
 * @Entity .domain.Subject
 */

public interface SubjectMapper extends BaseMapper<Subject> {
    /**
     * 根据科目名称获取科目id
     */
    @Select("select subid from subject where name = #{name}")
    Integer selectByName(String name);

    /**
     * 根据查询条件进行科目分页查询
     * @param start
     * @param size
     * @param subjectQuery
     * @return
     */
    List<Subject> selectByPageAndCondition(@Param("start")int start, @Param("size")int size, @Param("subjectCondition")SubjectQuery subjectQuery);

    /**
     * 根据条件获取查询条目总数
     * @param subjectQuery
     * @return
     */
    Integer getTotalCountByCondition(@Param("subjectCondition")SubjectQuery subjectQuery);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    Integer deleteByIds(@Param("subids")int[] ids);

    /**
     * 根据id单行删除
     * @param id
     * @return
     */
    @Delete("delete from subject where subid = #{id}")
    Integer deleteById(int id);

    @Insert("insert into subject values (#{subid},#{name})")
    Integer insertSubject(Subject subject);

    /**
     * 修改学生数据
     * @param subject
     * @return
     */
    @Update("update subject set name=#{name} where subid = #{subid}")
    Integer updateSubject(Subject subject);

}




