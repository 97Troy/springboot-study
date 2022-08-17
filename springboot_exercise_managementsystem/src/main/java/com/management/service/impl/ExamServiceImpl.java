package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.Vo.PageBeanVo;
import com.management.domain.Exam;
import com.management.domain.query.ExamQuery;
import com.management.service.ExamService;
import com.management.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rui_t
 * @description 针对表【exam】的数据库操作Service实现
 * @createDate 2022-08-08 15:56:37
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam>
        implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    /**
     * 根据考试场次名称获取id
     *
     * @param name
     * @return
     */
    @Override
    public Integer SelectByName(String name) {
        return examMapper.selectByName(name);
    }

    /**
     * 根据条件分页查询考试场次
     *
     * @param start
     * @param size
     * @param examQuery
     * @return
     */
    @Override
    public PageBeanVo selectByPageAndCondition(int start, int size, ExamQuery examQuery) {
        PageBeanVo<Exam> pageBeanVo = new PageBeanVo<>();

        List<Exam> exams = examMapper.selectByPageAndCondition(start, size, examQuery);
        long totalCountByPage = examMapper.getTotalCountByCondition(examQuery);

        pageBeanVo.setTotalCount(totalCountByPage);
        pageBeanVo.setRows(exams);

        return pageBeanVo;
    }

    /**
     * 根据id批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteByIds(int[] ids) {
        return examMapper.deleteByIds(ids) > 0;
    }

    /**
     * 根据id单行删除
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(int id) {
        return examMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean insertExam(Exam exam) {
        return examMapper.insertExam(exam) > 0;
    }

    @Override
    public Boolean updateExam(Exam exam) {
        return examMapper.updateExam(exam)>0;
    }
}




