package com.management.service;

import com.management.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author rui_t
* @description 针对表【user】的数据库操作Service
* @createDate 2022-08-11 14:13:58
*/
@Transactional
public interface UserService extends IService<User> {

}
