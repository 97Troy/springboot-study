package com.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.management.Vo.PageBeanVo;
import com.management.domain.Subject;
import com.management.domain.query.SubjectQuery;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【subject】的数据库操作Service
* @createDate 2022-08-08 15:56:37
*/
@Transactional
public interface SubjectService extends IService<Subject> {
    /**
     * 根据名称查询科目id
     * @param name
     * @return
     */
    Integer selectByName(String name);

    /**
     * 根据条件分页查询科目信息
     * @param start
     * @param size
     * @param subjectQuery
     * @return
     */
    PageBeanVo selectByPageAndCondition(int start, int size, SubjectQuery subjectQuery);

    /**
     * 根据id批量删除
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
     * 添加科目信息
     * @param subject
     * @return
     */
    Boolean insertSubject(Subject subject);

    /**
     * 修改科目信息
     * @param subject
     * @return
     */
    Boolean updateSubject(Subject subject);


}
