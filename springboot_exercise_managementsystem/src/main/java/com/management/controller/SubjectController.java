package com.management.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.management.Vo.PageBeanVo;
import com.management.domain.Code;
import com.management.domain.Result;
import com.management.domain.Subject;
import com.management.domain.query.SubjectQuery;
import com.management.mapper.SubjectMapper;
import com.management.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    //获取下拉框回显数据
    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(){
        List<Subject> subjects = subjectMapper.selectList(null);
        boolean flag = (subjects != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,subjects);
    }



    //分页查询数据（查询条件为空则为查询全部）
    @RequestMapping("/get")
    @ResponseBody
    public Result getByPage(@RequestBody SubjectQuery subjectQuery, @RequestParam("currentPage") int currentPage, @RequestParam("pageSize") int pageSize) {
        int start = (currentPage - 1) * pageSize;
        PageBeanVo pageBeanVo = subjectService.selectByPageAndCondition(start, pageSize,subjectQuery);
        Integer code = pageBeanVo.getRows() != null? Code.GET_OK: Code.GET_ERR;

        return new Result(code,pageBeanVo);
    }

    //批量删除
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteByIds(@RequestBody int[] subids){
        boolean flag = subjectService.deleteByIds(subids);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    //单行删除
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable int id){
        boolean flag = subjectService.deleteById(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    //添加科目
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertSubject(@RequestBody Subject subject){
        Subject subjectQuery = subjectMapper.selectById(subject.getSubid());
        if (subjectQuery != null){
            return new Result(Code.SAVE_ERR,false,"添加代码重复，清重新输入！");
        }

        boolean flag = subjectService.insertSubject(subject);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag,"添加失败");
    }

    //回显科目数据
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result getById(@PathVariable int id){
        Subject subject = subjectMapper.selectById(id);

        boolean flag = (subject != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,subject);
    }


    //修改科目
    @RequestMapping("/update")
    @ResponseBody
    public Result updateSubject(@RequestBody Subject subject){
        boolean flag = subjectService.updateSubject(subject);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
}
