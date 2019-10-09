package com.wyb.footprint.mapper;

import com.wyb.footprint.entity.LearningAchievementDO;
import com.wyb.footprint.entity.LengthOfStudyDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author William Wang
 */
@Component
public interface LearningAchievementMapper {
    @Insert("insert into learningAchievement (completionDate,achievement,userId) values( #{completionDate}, #{achievement}, #{userId})")
    void addLearningAchievement(LearningAchievementDO learningAchievementDO);
    @Select("SELECT * from learningAchievement WHERE userId = #{userId} ORDER BY completionDate DESC")
    List<LearningAchievementDO> getLearningAchievementsByUserId(@Param("userId") long userId);
}
