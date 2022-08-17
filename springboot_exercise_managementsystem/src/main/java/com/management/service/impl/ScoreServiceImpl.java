package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.Vo.PageBeanVo;
import com.management.Vo.ScoreVo;
import com.management.Vo.StatisticsVo;
import com.management.domain.Score;
import com.management.domain.query.ScoreQuery;
import com.management.domain.query.StatisticsQuery;
import com.management.mapper.ScoreMapper;
import com.management.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rui_t
 * @description 针对表【score】的数据库操作Service实现
 * @createDate 2022-08-08 15:56:37
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
        implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    /**
     * 分页查询成绩
     *
     * @param start
     * @param size
     * @return
     */
    @Override
    public PageBeanVo selectByPageAndCondition(int start, int size, ScoreQuery scoreQuery) {


        List<ScoreVo> scoreVos = scoreMapper.selectByPageAndCondition(start, size, scoreQuery);
        long totalCount = scoreMapper.getTotalCountByCondition(scoreQuery);

        //封装PageBeanVo对象
        PageBeanVo<ScoreVo> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setRows(scoreVos);
        pageBeanVo.setTotalCount(totalCount);

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
        return scoreMapper.deleteByIds(ids) > 0;
    }

    /**
     * 根据id单行删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(int id) {
        return scoreMapper.deleteById(id) > 0;
    }

    /**
     * 添加成绩记录
     *
     * @param score
     * @return
     */
    @Override
    public boolean insertScore(Score score) {
        return scoreMapper.insertScore(score) > 0;
    }

    /**
     * 修改成绩记录
     *
     * @param score
     * @return
     */
    @Override
    public boolean updateScore(Score score) {
        return scoreMapper.updateScore(score) > 0;
    }

    /**
     * 统计条件查询
     *
     * @param start
     * @param size
     * @param statisticsQuery
     * @return
     */
    @Override
    public PageBeanVo getStatByCondition(int start, int size, StatisticsQuery statisticsQuery) {
        String statType = statisticsQuery.getStatisticsType();
        List<StatisticsVo> result;
        List<StatisticsVo> view = new ArrayList<>();
        if ("平均值".equals(statType)) {
            result = scoreMapper.getAvgByCondition(start, size, statisticsQuery);
            for (StatisticsVo statisticsVo : result) {
                statisticsVo.setStatisticsType("平均值");
            }
        } else if ("最大值".equals(statType)) {
            result = scoreMapper.getMaxByCondition(start, size, statisticsQuery);
            for (StatisticsVo statisticsVo : result) {
                statisticsVo.setStatisticsType("最大值");
            }
        } else {
            result = scoreMapper.getMinByCondition(start, size, statisticsQuery);
            for (StatisticsVo statisticsVo : result) {
                statisticsVo.setStatisticsType("最小值");
            }
        }

        long totalCount = result.size();
        long n = size>totalCount?totalCount:size;
        int j = start;

        for (int i = 0; i < n; i++) {
            StatisticsVo statisticsVo = result.get(j);
            view.add(statisticsVo);
            j++;
        }

        PageBeanVo<StatisticsVo> pageBeanVo = new PageBeanVo<>();
        pageBeanVo.setTotalCount(totalCount);
        pageBeanVo.setRows(view);

        return pageBeanVo;
    }
}




