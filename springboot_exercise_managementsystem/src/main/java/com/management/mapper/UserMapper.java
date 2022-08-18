package com.management.mapper;

import com.management.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
* @author rui_t
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-08-11 14:13:58
* @Entity com.management.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Insert("insert into user values (#{uid},#{username},#{password},#{identity})")
    Integer insertUser(User user);

}




