package com.example.springboot_exercise_managementsystem;

import com.management.SpringbootExerciseManagementsystemApplication;
import com.management.Vo.PageBeanVo;
import com.management.domain.Classroom;
import com.management.domain.Subject;
import com.management.domain.User;
import com.management.domain.query.ScoreQuery;
import com.management.domain.query.SubjectQuery;
import com.management.mapper.*;
import com.management.service.ScoreService;
import com.management.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SpringbootExerciseManagementsystemApplication.class)
class SpringbootExerciseManagementsystemApplicationTests {

    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelectByPage() {
        ScoreQuery scoreQuery = new ScoreQuery();
        //List<ScoreVo> scoreVos = scoreMapper.selectByPageAndCondition(1, 5, scoreQuery);
        //System.out.println(scoreVos);
        //Integer totalCountByCondition = scoreMapper.getTotalCountByCondition(scoreQuery);
        //System.out.println(totalCountByCondition);
        PageBeanVo pageBeanVo = scoreService.selectByPageAndCondition(0, 5, scoreQuery);
        System.out.println(pageBeanVo.getRows());
    }

    @Test
    public void testDeleteByIds(){
        //long[] ids = {1,2};
        //boolean b = service.deleteByIds(ids);
        //System.out.println(b);

    }

    @Test
    public void testInsert(){
        //Score score = new Score();
        //score.setEid(2);
        //score.setSid(3);
        //score.setSubid(1);
        //score.setScore(99);
        //
        //boolean flag = service.insertScore(score);
        //System.out.println(flag);
    }

    @Test
    public void testGetIdBySubject(){
        String name = "历史";
        Integer integer = subjectService.selectByName(name);
        System.out.println(integer);
    }

    @Test
    public void testSelectStudentByPage(){
        String s = "";
        System.out.println(""==null);

    }

    @Test
    public void testGetAll(){
        List<Classroom> classes = classroomMapper.selectList(null);
        System.out.println(classes);
    }

    @Test
    public void testSubject(){
        SubjectQuery subjectQuery = new SubjectQuery();
        //List<Subject> subjects = subjectMapper.selectByPageAndCondition(0, 5, subjectQuery);
        //System.out.println(subjects);
        //Integer totalCountByCondition = subjectMapper.getTotalCountByCondition(subjectQuery);
        //System.out.println(totalCountByCondition);
        //int[] id= {1001};
        //Boolean aBoolean = subjectService.deleteByIds(id);
        //System.out.println(aBoolean);
        Subject subject = new Subject();
        subject.setSubid(1009);
        subject.setName("语文");
        Integer integer = subjectMapper.insertSubject(subject);
        System.out.println(integer);


    }

    @Test
    public void testScore(){
        //Score score = new Score();
        //score.setSid(2022081101);
        //score.setEid(20210101);
        //score.setSubid(1004);
        //score.setScore(120);
        //
        ////Integer integer = scoreMapper.insertScore(score);
        ////System.out.println(integer);
        //
        //boolean b = scoreService.insertScore(score);
        //System.out.println(b);

        //StatisticsQuery statisticsQuery = new StatisticsQuery();
        ////statisticsQuery.setExam("2020第一学期期中考试");
        ////statisticsQuery.setClassName("高二四班");
        //statisticsQuery.setStatisticsType("最大值");
        //statisticsQuery.setSubject("语文");
        //
        //PageBeanVo statByCondition = scoreService.getStatByCondition(0, 5, statisticsQuery);
        //System.out.println(statByCondition.getRows()+".... "+statByCondition.getTotalCount());

        ScoreQuery scoreQuery = new ScoreQuery();
        scoreQuery.setSubject("数学");
        scoreMapper.selectByPageAndCondition(0,5,scoreQuery);
    }

    @Test
    public void testUser(){
        User user = new User();
        //user.setUsername("fengli");
        user.setUsername("2022081001");
        user.setPassword("2022081001");
        User login = userMapper.login(user);
        System.out.println(login);

    }


}
