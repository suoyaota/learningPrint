package com.wyb.footprint.service;

import com.wyb.footprint.entity.UserDO;

import javax.servlet.http.HttpSession;

/**
 * @Author William Wang
 */
public interface UserService {
    String signUp(UserDO userDO);
    String checkUserName(String userName);
    String signIn(UserDO userDO, HttpSession session);
    String getNameByUserId(long userId);
    Long getUserIdByUserName(String userName);
}
