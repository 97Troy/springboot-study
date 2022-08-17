package com.management.service;

import com.management.Vo.PageBeanVo;
import com.management.domain.Exam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.management.domain.query.ExamQuery;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【exam】的数据库操作Service
* @createDate 2022-08-08 15:56:37
*/
@Transactional
public interface ExamService extends IService<Exam> {
    /**
     * 根据名称查询考试场次id
     * @param name
     * @return
     */
    Integer SelectByName(String name);

    /**
     * 根据条件分页查询考试场次
     * @param start
     * @param size
     * @param examQuery
     * @return
     */
    PageBeanVo selectByPageAndCondition(int start, int size, ExamQuery examQuery);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    Boolean deleteByIds(int[] ids);

    /**
     * 根据id单行删除
     * @param id
     * @return
     */
    Boolean deleteById(int id);

    /**
     * 添加考试场次信息
     * @param exam
     * @return
     */
    Boolean insertExam(Exam exam);

    /**
     * 修改考试场次信息
     * @param exam
     * @return
     */
    Boolean updateExam(Exam exam);

}
