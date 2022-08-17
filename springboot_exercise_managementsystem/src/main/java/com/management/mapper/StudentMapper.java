package com.management.mapper;

import com.management.Vo.StudentVo;
import com.management.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.domain.query.StudentQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author rui_t
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-08-11 14:12:19
* @Entity com.management.domain.Student
*/

public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 分页查询学生信息
     * @param start
     * @param size
     * @return
     */
    List<StudentVo> selectByPageAndCondition(@Param("start")int start, @Param("size")int size, @Param("studentCondition") StudentQuery student);

    /**
     * 查询学生信息总条目数
     * @return
     */
    Integer getTotalCountByCondition(@Param("studentCondition") StudentQuery student);

    /**
     * 批量删除学生信息
     * @param ids
     * @return
     */
    Integer deleteByIds(@Param("sids")int[] ids);

    /**
     * 根据单个id删除
     * @param id
     * @return
     */
    @Delete("delete from student_management.student where sid=#{id}")
    Integer deleteById(int id);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @Insert("insert into student_management.student values (#{sid},#{name},#{sex},#{classCode})")
    Integer insertStudent(Student student);

    /**
     * 修改学生数据
     * @param student
     * @return
     */
    @Update("update student_management.student set name=#{name},sex=#{sex},class_code=#{classCode} where sid = #{sid}")
    Integer updateStudent(Student student);
}




