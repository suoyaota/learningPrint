package com.wyb.footprint.service.impl;

import com.wyb.footprint.entity.LearningAchievementDO;
import com.wyb.footprint.entity.LengthOfStudyDO;
import com.wyb.footprint.mapper.LearningAchievementMapper;
import com.wyb.footprint.mapper.LengthOfStudyMapper;
import com.wyb.footprint.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author William Wang
 */
@Service
public class LearningServiceImpl implements LearningService {
    @Autowired
    LengthOfStudyMapper lengthOfStudyMapper;
    @Autowired
    LearningAchievementMapper learningAchievementMapper;
    @Override
    public void addStudyLength(long userId, String studyDate, Double studyTime) throws ParseException {
        java.util.Date studyDateUtil = new SimpleDateFormat("yyyy-MM-dd").parse(studyDate);
        java.sql.Date studyDateSql = new java.sql.Date(studyDateUtil.getTime());
        LengthOfStudyDO lengthOfStudyDO = new LengthOfStudyDO();
        lengthOfStudyDO.setStudyDate(studyDateSql);
        lengthOfStudyDO.setUserId(userId);
        lengthOfStudyDO.setStudyTime(studyTime);
        lengthOfStudyMapper.addStudyLength(lengthOfStudyDO);
    }

    @Override
    public void addLearningAchievement(long userId, String completionDate, String achievement) throws ParseException {
        java.util.Date completionDateUtil = new SimpleDateFormat("yyyy-MM-dd").parse(completionDate);
        java.sql.Date completionDateSql = new java.sql.Date(completionDateUtil.getTime());
        LearningAchievementDO learningAchievementDO = new LearningAchievementDO();
        learningAchievementDO.setAchievement(achievement);
        learningAchievementDO.setCompletionDate(completionDateSql);
        learningAchievementDO.setUserId(userId);
        learningAchievementMapper.addLearningAchievement(learningAchievementDO);
    }

    @Override
    public List<LengthOfStudyDO> getStudyLengthByUserId(long userId) {
        return lengthOfStudyMapper.getLengthOfStudyDOsByUserId(userId);
    }

    @Override
    public List<LearningAchievementDO> getLearningAchievementByUserId(long userId) {
        return learningAchievementMapper.getLearningAchievementsByUserId(userId);
    }
}
