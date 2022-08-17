package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.Vo.PageBeanVo;
import com.management.domain.Subject;
import com.management.domain.query.SubjectQuery;
import com.management.service.SubjectService;
import com.management.mapper.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author rui_t
* @description 针对表【subject】的数据库操作Service实现
* @createDate 2022-08-08 15:56:37
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 根据科目名称查询id
     * @param name
     * @return
     */
    @Override
    public Integer selectByName(String name) {
        return subjectMapper.selectByName(name);
    }

    /**
     * 根据条件分页查询科目信息
     * @param start
     * @param size
     * @param subjectQuery
     * @return
     */
    @Override
    public PageBeanVo selectByPageAndCondition(int start, int size, SubjectQuery subjectQuery) {
        PageBeanVo<Subject> subjectPageBeanVo = new PageBeanVo<>();

        List<Subject> subjects = subjectMapper.selectByPageAndCondition(start, size, subjectQuery);
        long totalCountByCondition = subjectMapper.getTotalCountByCondition(subjectQuery);

        //封装数据
        subjectPageBeanVo.setTotalCount(totalCountByCondition);
        subjectPageBeanVo.setRows(subjects);
        return subjectPageBeanVo;

    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteByIds(int[] ids) {
        return subjectMapper.deleteByIds(ids)>0;
    }

    /**
     * 根据id单行删除
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(int id) {
        return subjectMapper.deleteById(id)>0;
    }

    /**
     * 添加科目信息
     * @param subject
     * @return
     */
    @Override
    public Boolean insertSubject(Subject subject) {
        return subjectMapper.insertSubject(subject)>0;
    }

    /**
     * 修改科目信息
     * @param subject
     * @return
     */
    @Override
    public Boolean updateSubject(Subject subject) {
        return subjectMapper.updateSubject(subject)>0;
    }
}




