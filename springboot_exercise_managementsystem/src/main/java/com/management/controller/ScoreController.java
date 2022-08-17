package com.management.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.management.Vo.PageBeanVo;
import com.management.domain.Code;
import com.management.domain.Result;
import com.management.domain.Score;
import com.management.domain.query.ScoreQuery;
import com.management.domain.query.StatisticsQuery;
import com.management.mapper.ScoreMapper;
import com.management.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private ScoreMapper scoreMapper;

    //分页条件查询
    @RequestMapping("/get")
    @ResponseBody
    public Result getByPage(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestBody ScoreQuery scoreQuery) {
        int start = (currentPage - 1)*pageSize;
        PageBeanVo pageBeanVo = scoreService.selectByPageAndCondition(start, pageSize, scoreQuery);

        Integer code = pageBeanVo.getRows() != null? Code.GET_OK:Code.GET_ERR;
        return new Result(code,pageBeanVo);
    }

    //根据id批量删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteByIds(@RequestBody int[] ids){
        boolean flag = scoreService.deleteByIds(ids);
        return new Result(flag? Code.DELETE_OK: Code.DELETE_ERR,flag);
    }

    //根据id单行删除
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable int id){
        boolean flag = scoreService.deleteById(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    //添加成绩记录
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertScore(@RequestBody Score score){
        LambdaQueryWrapper<Score> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Score::getSubid,score.getSubid());
        wrapper.eq(Score::getSid,score.getSid());
        wrapper.eq(Score::getEid,score.getEid());
        Score scoreQuery = scoreMapper.selectOne(wrapper);

        if (scoreQuery != null){
            return new Result(Code.SAVE_ERR,false,"成绩添加重复，请重新输入！");
        }


        boolean flag = scoreService.insertScore(score);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag,"添加失败，请重新输入！");
    }

    //修改成绩记录回显
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result getById(@PathVariable int id){
        Score score = scoreMapper.selectById(id);

        boolean flag = (score != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,score);
    }

    //修改成绩记录
    @RequestMapping("/update")
    @ResponseBody
    public Result updateScore(@RequestBody Score score){
        boolean flag = scoreService.updateScore(score);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    //条件统计查询
    @RequestMapping("/getStat")
    @ResponseBody
    public Result getStatByCondition(@RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize, @RequestBody StatisticsQuery statisticsQuery) {
        int start = (currentPage - 1)*pageSize;
        PageBeanVo pageBeanVo = scoreService.getStatByCondition(start, pageSize, statisticsQuery);
        Integer code = pageBeanVo.getRows() != null? Code.GET_OK:Code.GET_ERR;
        return new Result(code,pageBeanVo);
    }
}
