package com.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.management.domain.User;
import com.management.service.UserService;
import com.management.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author rui_t
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-11 14:13:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




