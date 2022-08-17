package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user = new User();
        user.setUsername("heima");
        user.setPassword("heima");
        user.setAge(20);
        user.setTel("1881888");
        userDao.insert(user);
    }

    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1555441640437379074L);
    }

    @Test
    void testUpdate(){
        User user = new User();
        user.setUsername("tomlll");
        user.setId(1L);
        userDao.updateById(user);
    }

    @Test
    void testGetById(){
        User user = userDao.selectById(2L);
        System.out.println(user);
    }

    @Test
    void testGetByPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值"+page.getCurrent());
        System.out.println("每页显示条目数"+page.getSize());
        System.out.println("一共多少页"+page.getPages());
        System.out.println("一共多少条数据"+page.getTotal());
        System.out.println("数据"+page.getRecords());
    }

}
