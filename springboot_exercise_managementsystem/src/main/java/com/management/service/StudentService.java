package com.management.service;

import com.management.Vo.PageBeanVo;
import com.management.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.query.StudentQuery;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【student】的数据库操作Service
* @createDate 2022-08-11 14:12:19
*/
@Transactional
public interface StudentService extends IService<Student> {
    /**
     * 分页查询学生信息
     * @param start
     * @param size
     * @return
     */
    PageBeanVo selectStudentByPageByCondition(int start, int size, StudentQuery student);

    /**
     * 批量删除学生信息
     * @param ids
     * @return
     */
    boolean deleteByIds(int[] ids);

    /**
     * 根据单个id删除
     * @param id
     * @return
     */
    boolean deleteById(int id);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    boolean insertStudent(Student student);

    /**
     * 修改学生数据
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

}
