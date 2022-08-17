package com.management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.management.Vo.PageBeanVo;
import com.management.domain.Score;
import com.management.domain.query.ScoreQuery;
import com.management.domain.query.StatisticsQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author rui_t
* @description 针对表【score】的数据库操作Service
* @createDate 2022-08-08 15:56:37
*/
@Transactional
public interface ScoreService extends IService<Score> {
    /**
     * 分页查询成绩
     * @param start
     * @param size
     * @return
     */
     PageBeanVo selectByPageAndCondition(int start, int size, ScoreQuery scoreQuery);

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
     boolean deleteById(int id);

    /**
     * 添加成绩记录
     */
    boolean insertScore(Score score);

    /**
     * 修改成绩记录
     * @param score
     * @return
     */
    boolean updateScore(Score score);

    /**
     * 统计条件查询
     * @param start
     * @param size
     * @param statisticsQuery
     * @return
     */
    PageBeanVo getStatByCondition(int start, int size, StatisticsQuery statisticsQuery);





}
