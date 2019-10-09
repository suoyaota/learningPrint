package com.wyb.footprint.service;

import com.wyb.footprint.entity.LearningAchievementDO;
import com.wyb.footprint.entity.LengthOfStudyDO;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @Author William Wang
 */
public interface LearningService {
    void addStudyLength(long userId,String studyDate,Double studyTime)throws ParseException;
    void addLearningAchievement(long userId,String completionDate,String achievement)throws ParseException;
    List<LengthOfStudyDO> getStudyLengthByUserId(long userId);
    List<LearningAchievementDO> getLearningAchievementByUserId(long userId);
}
