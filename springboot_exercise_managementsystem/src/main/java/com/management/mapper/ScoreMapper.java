package com.management.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.management.Vo.ScoreVo;
import com.management.Vo.StatisticsVo;
import com.management.domain.Score;
import com.management.domain.query.ScoreQuery;
import com.management.domain.query.StatisticsQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author rui_t
* @description 针对表【score】的数据库操作Mapper
* @createDate 2022-08-08 15:56:37
* @Entity .domain.Score
*/

public interface ScoreMapper extends BaseMapper<Score> {
     /**
      * 根据条件分页查询
      * @param start
      * @param size
      * @return
      */
     List<ScoreVo> selectByPageAndCondition(@Param("start")int start, @Param("size") int size, @Param("scoreCondition")ScoreQuery scoreQuery);

     /**
      * 根据条件获取总条目数
      * @param scoreQuery
      * @return
      */
     Integer getTotalCountByCondition(@Param("scoreCondition")ScoreQuery scoreQuery);

     /**
      * 根据id批量删除
      * @param ids
      * @return
      */
     Integer deleteByIds(@Param("ids")int[] ids);

     /**
      * 根据id单行删除
      * @param id
      * @return
      */
     @Delete("delete from score where id = #{id}")
     Integer deleteById(int id);

     /**
      * 添加成绩记录
      */
     @Insert("insert into score values (null,#{sid},#{subid},#{eid},#{score})")
     Integer insertScore(Score score);

     /**
      * 修改成绩记录
      * @param score
      * @return
      */
     @Update("update score set subid=#{subid},eid=#{eid},score=#{score} where id=#{id}")
     Integer updateScore(Score score);

     List<StatisticsVo> getAvgByCondition(@Param("start")int start, @Param("size") int size, @Param("condition")StatisticsQuery statisticsQuery);

     List<StatisticsVo> getMaxByCondition(@Param("start")int start, @Param("size") int size, @Param("condition")StatisticsQuery statisticsQuery);

     List<StatisticsVo> getMinByCondition(@Param("start")int start, @Param("size") int size, @Param("condition")StatisticsQuery statisticsQuery);
}




