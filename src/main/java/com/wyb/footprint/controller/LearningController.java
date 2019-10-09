package com.wyb.footprint.controller;

import com.wyb.footprint.entity.LearningAchievementDO;
import com.wyb.footprint.entity.LengthOfStudyDO;
import com.wyb.footprint.mapper.UserMapper;
import com.wyb.footprint.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

/**
 * @Author William Wang
 */
@Controller
public class LearningController {
    @Autowired
    LearningService learningService;
    @Autowired
    UserMapper userMapper;
    @PostMapping(value = "/updateStudyLength")
    public String updateStudyLength (@RequestParam("studyDate")String studyDate,
                                     @RequestParam("studyLength")Double studyLength,
                                     HttpSession session) throws ParseException {
        String userName = (String) session.getAttribute("loginUserName");
        Long userId = userMapper.getUserIdByUserName(userName);
        learningService.addStudyLength(userId,studyDate,studyLength);
        return "redirect:/SignInSuccess";
//        java.util.Date studyDateUtil = new SimpleDateFormat("yyyy-MM-dd").parse(studyDate);
//        java.sql.Date studyDateSql = new java.sql.Date(studyDateUtil.getTime());
    }

    @PostMapping(value = "/updateLearningAchievement")
    public String udpateLearningAchievement (@RequestParam("completionDate") String completionDate,
                                             @RequestParam("achievement") String achievement,
                                             HttpSession session) throws ParseException {
        String userName = (String) session.getAttribute("loginUserName");
        Long userId = userMapper.getUserIdByUserName(userName);
        learningService.addLearningAchievement(userId,completionDate,achievement);
        return "redirect:/SignInSuccess";
    }

    @ResponseBody
    @GetMapping(value = "/getLengthData")
    public List<LengthOfStudyDO> getLengthData(HttpSession session) {
        String userName = (String) session.getAttribute("loginUserName");
        Long userId = userMapper.getUserIdByUserName(userName);
        List<LengthOfStudyDO> ls = learningService.getStudyLengthByUserId(userId);
        return ls;
    }

    @ResponseBody
    @GetMapping(value = "/getGraphData")
    public List<LearningAchievementDO> getAchievement(HttpSession session) {
        String userName = (String) session.getAttribute("loginUserName");
        Long userId = userMapper.getUserIdByUserName(userName);
        List<LearningAchievementDO> la = learningService.getLearningAchievementByUserId(userId);
        return la;
    }
}
