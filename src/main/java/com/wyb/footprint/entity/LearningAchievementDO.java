package com.wyb.footprint.entity;

import lombok.Data;

/**
 * @Author William Wang
 */
@Data
public class LearningAchievementDO {
    private Long achievementId;
    private java.sql.Date completionDate;
    private String achievement;
    private Long userId;
}
