package com.management.service;

import com.management.domain.Classroom;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【classroom】的数据库操作Service
* @createDate 2022-08-12 08:50:50
*/
@Transactional
public interface ClassroomService extends IService<Classroom> {

}
