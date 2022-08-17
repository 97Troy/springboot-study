package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.domain.Classroom;
import com.management.service.ClassroomService;
import com.management.mapper.ClassroomMapper;
import org.springframework.stereotype.Service;

/**
* @author rui_t
* @description 针对表【classroom】的数据库操作Service实现
* @createDate 2022-08-12 08:50:50
*/
@Service
public class ClassroomServiceImpl extends ServiceImpl<ClassroomMapper, Classroom>
    implements ClassroomService{

}




