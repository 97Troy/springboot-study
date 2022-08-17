package com.management.service;

import com.management.domain.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【teacher】的数据库操作Service
* @createDate 2022-08-11 14:08:08
*/
@Transactional
public interface TeacherService extends IService<Teacher> {

}
