package com.wyb.footprint.mapper;

import com.wyb.footprint.entity.LengthOfStudyDO;
import com.wyb.footprint.entity.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author William Wang
 */
@Component
public interface LengthOfStudyMapper {
    @Insert("insert into lengthOfStudy (studyDate,studyTime,userId) values( #{studyDate}, #{studyTime}, #{userId})")
    void addStudyLength(LengthOfStudyDO lengthOfStudyDO);
    @Select("SELECT * FROM lengthOfStudy WHERE userId = #{userId} ")
    List<LengthOfStudyDO> getLengthOfStudyDOsByUserId(@Param("userId") long userId);
}
