package com.wyb.footprint.controller;

import com.wyb.footprint.entity.UserDO;
import com.wyb.footprint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author William Wang
 */

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "/")
    public String signIn() {
        return "signIn";
    }
    @GetMapping(value = "/toSignUp")
    public String toSignUp() {
        return "signUp";
    }
    @ResponseBody
    @GetMapping("/userName/check")
    public String checkUserName(String userName){
        return userService.checkUserName(userName);
    }
    @ResponseBody
    @PostMapping(value = "/signUp")
    public String signUp(UserDO userDO) {
        return userService.signUp(userDO);
    }
    @ResponseBody
    @PostMapping(value = "/signIn")
    public String signIn(UserDO userDO, HttpSession session) {
        return userService.signIn(userDO,session);
    }
    @GetMapping(value = "/SignInSuccess")
    public String loginSuccess(HttpSession session, Model m) {
        String userName = (String) session.getAttribute("loginUserName");
        m.addAttribute("userName",userName);
        return "learningPrint";
    }

}
