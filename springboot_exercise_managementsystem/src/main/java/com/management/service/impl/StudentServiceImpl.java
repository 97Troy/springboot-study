package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.Vo.PageBeanVo;
import com.management.Vo.StudentVo;
import com.management.domain.Student;
import com.management.domain.query.StudentQuery;
import com.management.service.StudentService;
import com.management.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rui_t
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-08-11 14:12:19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询学生信息
     *
     * @param start
     * @param size
     * @return
     */
    @Override
    public PageBeanVo selectStudentByPageByCondition(int start, int size, StudentQuery student) {
        PageBeanVo<StudentVo> studentPageBeanVo = new PageBeanVo<>();

        List<StudentVo> students = studentMapper.selectByPageAndCondition(start, size, student);
        long totalCount = studentMapper.getTotalCountByCondition(student);

        //封装数据
        studentPageBeanVo.setRows(students);
        studentPageBeanVo.setTotalCount(totalCount);
        return studentPageBeanVo;
    }

    /**
     * 批量删除学生信息
     *
     * @param ids
     * @return
     */
    @Override
    public boolean deleteByIds(int[] ids) {
        return studentMapper.deleteByIds(ids) > 0;
    }

    /**
     * 根据单个id删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(int id) {
        return studentMapper.deleteById(id) > 0;
    }

    /**
     * 添加学生信息
     *
     * @param student
     * @return
     */
    @Override
    public boolean insertStudent(Student student) {
        return studentMapper.insertStudent(student) > 0;
    }

    /**
     * 修改学生数据
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student) > 0;
    }
}




