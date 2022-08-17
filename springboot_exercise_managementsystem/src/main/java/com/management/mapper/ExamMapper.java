package com.management.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.Exam;
import com.management.domain.query.ExamQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author rui_t
* @description 针对表【exam】的数据库操作Mapper
* @createDate 2022-08-08 15:56:37
* @Entity .domain.Exam
*/
@Mapper
public interface ExamMapper extends BaseMapper<Exam> {
    /**
     * 根据考试场次名称获取考试场次id
     * @param name
     * @return
     */
    @Select("select eid from exam where name = #{name}")
    Integer selectByName(String name);

    /**
     * 根据条件分页查询考试场次
     * @param start
     * @param size
     * @return
     */
    List<Exam> selectByPageAndCondition(@Param("start")int start, @Param("size")int size, @Param("examCondition")ExamQuery examQuery);

    /**
     * 根据条件获取所有条目数
     * @param examQuery
     * @return
     */
    Integer getTotalCountByCondition(@Param("examCondition")ExamQuery examQuery);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    Integer deleteByIds(@Param("eids")int[] ids);

    /**
     * 根据id单行删除
     * @param id
     * @return
     */
    @Delete("delete from exam where eid = #{id}")
    Integer deleteById(int id);

    /**
     * 添加考试场次信息
     * @param exam
     * @return
     */
    @Insert("insert into exam values (#{eid},#{name})")
    Integer insertExam(Exam exam);

    /**
     * 修改考试场次信息
     * @param exam
     * @return
     */
    @Update("update exam set name = #{name} where eid = #{eid}")
    Integer updateExam(Exam exam);

}




