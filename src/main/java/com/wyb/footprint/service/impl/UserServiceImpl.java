package com.wyb.footprint.service.impl;

import com.wyb.footprint.entity.UserDO;
import com.wyb.footprint.mapper.UserMapper;
import com.wyb.footprint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Author William Wang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String signUp(UserDO userDO){
        userDO.setPassword(BCrypt.hashpw(userDO.getPassword(),BCrypt.gensalt()));
        userMapper.signUp(userDO);
        return "1";
    }

    @Override
    public String checkUserName(String userName){
        Long id = userMapper.getUserIdByUserName(userName);
        if(Objects.isNull(id)){
            //return "<font color='green'>可以使用</font>";
            return "1";
        }else {
            return "0";
        }
    }


    @Override
    public String signIn(UserDO userDO, HttpSession session){

        String userName = userDO.getUserName();
        String password = userDO.getPassword();
        String truePassword = userMapper.getPasswordByUserName(userName);
        if(truePassword != null && BCrypt.checkpw(password,truePassword)){
            Long loginUserId = userMapper.getUserIdByUserName(userName);
            session.setAttribute("loginUserName",userDO.getUserName());
            return loginUserId.toString();
        }else{
            //登录失败
            return "0";
        }
    }
    @Override
    public String getNameByUserId(long userId){
        return userMapper.getNameByUserId(userId);
    }
    @Override
    public Long getUserIdByUserName(String userName) {
        return userMapper.getUserIdByUserName(userName);
    }
}
