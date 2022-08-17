package com.management.controller;

import com.management.domain.Classroom;
import com.management.domain.Code;
import com.management.domain.Result;
import com.management.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassController {
    @Autowired
    private ClassroomMapper classroomMapper;

    //获取下拉框回显数据
    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(){
        List<Classroom> classes = classroomMapper.selectList(null);
        boolean flag = (classes != null);
        return new Result(flag? Code.GET_OK:Code.GET_ERR,classes);
    }
}
