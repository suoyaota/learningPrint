package com.wyb.footprint.entity;

import lombok.Data;

/**
 * @Author William Wang
 */
@Data
public class LengthOfStudyDO {
    private Long infoId;
    private java.sql.Date studyDate;
    private Double studyTime;
    private Long userId;
}
