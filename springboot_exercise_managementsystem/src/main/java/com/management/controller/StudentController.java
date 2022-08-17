package com.management.controller;

import com.management.Vo.PageBeanVo;
import com.management.domain.Code;
import com.management.domain.Result;
import com.management.domain.Student;
import com.management.domain.query.StudentQuery;
import com.management.mapper.ClassroomMapper;
import com.management.mapper.StudentMapper;
import com.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassroomMapper classroomMapper;


    //获取下拉框回显数据
    @RequestMapping("/getAll")
    @ResponseBody
    public Result getAll(){
        List<Student> students = studentMapper.selectList(null);
        boolean flag = (students != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,students);
    }


    //分页查询获取数据（查询条件全为空则表示查询全部）
    @RequestMapping("/get")
    @ResponseBody
    public Result getByPage(@RequestBody StudentQuery student,@RequestParam("currentPage") int currentPage,@RequestParam("pageSize") int pageSize){
        int start= (currentPage-1)*pageSize;
        PageBeanVo pageBeanVo = studentService.selectStudentByPageByCondition(start, pageSize,student);
        Integer code = pageBeanVo.getRows() != null? Code.GET_OK: Code.GET_ERR;
        return new Result(code,pageBeanVo);
    }

    //回显学生数据
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result getById(@PathVariable int id){
        Student student = studentMapper.selectById(id);

        boolean flag = (student != null);
        return new Result(flag?Code.GET_OK:Code.GET_ERR,student);
    }


    //批量删除学生信息
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteByIds(@RequestBody int[] sids){
        boolean flag = studentService.deleteByIds(sids);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    //根据id删除
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable int id){
        boolean flag = studentService.deleteById(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    //添加学生信息
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertStudent(@RequestBody Student student){
        //判断学号是否重复
        Student studentQuery = studentMapper.selectById(student.getSid());
        if (studentQuery != null){
            return new Result(Code.SAVE_ERR,false,"添加学号重复，清重新输入！");
        }
        boolean flag = studentService.insertStudent(student);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag,"添加失败！");
    }


    //修改学生信息
    @RequestMapping("/update")
    @ResponseBody
    public Result updateStudent(@RequestBody Student student){
        boolean flag = studentService.updateStudent(student);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }



}
