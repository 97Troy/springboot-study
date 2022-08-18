package com.management.controller;

import com.management.domain.*;
import com.management.mapper.StudentMapper;
import com.management.mapper.TeacherMapper;
import com.management.mapper.UserMapper;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserMapper userMapper;

    //用户登录（用户名或uid）
    @RequestMapping("/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        User userQuery = userService.login(user);

        HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        httpSession.setAttribute("user", userQuery);

        if (userQuery != null) {
            return new Result(Code.LOGIN_OK, userQuery.getIdentity());
        } else {
            return new Result(Code.LOGIN_ERR, false);
        }

    }

    //用户登出
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() {
        HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        httpSession.invalidate();
        return new Result(101, true);
    }

    //用户注册
    @RequestMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        int identity = user.getIdentity();
        //判断注册权限
       if (identity==1){
            Teacher teacher = teacherMapper.selectById(user.getUid());
            if (teacher == null){//老师表中不存在uid，权限不足
                return new Result(Code.REGISTER_ERR,false,"注册失败,权限不足！");
            }else {//存在uid，判断账号是否已经注册
                User user1 = userMapper.selectById(user.getUid());
                if (user1 != null){
                    return new Result(Code.REGISTER_ERR,false,"注册失败，账号已存在!");
                }else {//有权限，未注册，提供注册
                    boolean flag = userMapper.insertUser(user)>0;
                    return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag,"注册失败！");
                }
            }
        }else {
           Student student = studentMapper.selectById(user.getUid());
           if (student == null){//学生表中不存在uid，权限不足
               return new Result(Code.REGISTER_ERR,false,"注册失败,权限不足！");
           }else {//存在uid，判断账号是否已经注册
               User user1 = userMapper.selectById(user.getUid());
               if (user1 != null){
                   return new Result(Code.REGISTER_ERR,false,"注册失败，账号已存在!");
               }else {//有权限，未注册，提供注册
                   boolean flag = userMapper.insertUser(user)>0;
                   return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag,"注册失败！");
               }
           }
        }
    }


}
