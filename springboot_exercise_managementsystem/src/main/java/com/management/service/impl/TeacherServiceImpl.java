package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.domain.Teacher;
import com.management.service.TeacherService;
import com.management.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author rui_t
* @description 针对表【teacher】的数据库操作Service实现
* @createDate 2022-08-11 14:08:08
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}




