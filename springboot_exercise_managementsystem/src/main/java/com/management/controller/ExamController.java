package com.management.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.management.Vo.PageBeanVo;
import com.management.domain.Code;
import com.management.domain.Exam;
import com.management.domain.Result;
import com.management.domain.query.ExamQuery;
import com.management.mapper.ExamMapper;
import com.management.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.Oneway;
import java.util.List;

@Controller
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private ExamMapper examMapper;

    //获取下拉框回显数据
    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(){
        List<Exam> exams = examMapper.selectList(null);
        boolean flag = (exams != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,exams);
    }



    //条件分页查询（条件为空时查询全部）
    @RequestMapping("/get")
    @ResponseBody
    public Result getByPage(@RequestBody ExamQuery examQuery, @RequestParam int currentPage, @RequestParam int pageSize) {
        int start = (currentPage - 1) * pageSize;

        PageBeanVo pageBeanVo = examService.selectByPageAndCondition(start, pageSize, examQuery);

        Integer code = pageBeanVo.getRows() != null ? Code.GET_OK : Code.GET_ERR;

        return new Result(code, pageBeanVo);
    }

    //根据id批量删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteByIds(@RequestBody int[] ids) {
        Boolean flag = examService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }


    //根据id单行删除
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable int id) {
        Boolean flag = examService.deleteById(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    //添加考试场次信息
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertExam(@RequestBody Exam exam) {
        Exam examQuery = examMapper.selectById(exam.getEid());

        if (examQuery != null) {
            return new Result(Code.UPDATE_ERR, false, "考试场次代码重复，请重新输入！");
        }

        Boolean flag = examService.insertExam(exam);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag, "添加失败！");

    }

    //根据id回显考试场次信息
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result getById(@PathVariable int id) {
        Exam exam = examMapper.selectById(id);
        boolean flag = (exam != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,exam);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result updateExam(@RequestBody Exam exam){
        Boolean flag = examService.updateExam(exam);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

}
