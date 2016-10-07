package com.hexian.web.controller;

import com.hexian.web.service.UserServices;
import com.hzit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserServices userServices;

    @RequestMapping("/dologin")
    public String login(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
        User user=userServices.findone(username,password);
        if (user==null){
            return "redirect:/login.html";
        }else{
            session.setAttribute("user",user);
            return "redirect:/bypage";
        }
    }
    @RequestMapping("/loginout")
    public String loginout(HttpSession session){
             session.invalidate();
            return "redirect:/login.html";

    }
    @RequestMapping("/insert")
    public String insert(User user){
        int num=userServices.insert(user);
        if (num==1){
            return "register_success.html";
        }else {
            return "register.html";
        }

    }



}