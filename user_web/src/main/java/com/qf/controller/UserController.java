package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.pojo.User;
import com.qf.service.MailService;
import com.qf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by  .Life on 2019/06/29/0029 11:19
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Reference
    private MailService mailService;
    @Reference
    private UserService userService;

    @RequestMapping("/sendmail")
    @ResponseBody
    public String sendMail(String email, HttpSession session){
        System.out.println(email);
        String code = mailService.sendEmail(email);
        session.setAttribute("code",code);
        return "success";
    }
    @RequestMapping("/check")
    public void check(String code,HttpSession session,HttpServletResponse response) {
        if (code.equals(session.getAttribute("code"))) {
            try {
                response.getWriter().write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/toregister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/register")
    public String register(User user){
            userService.insert(user);
            return "login";
    }
    @RequestMapping("/login")
    public String login(User user, Model model){
        boolean query = userService.query(user);
        if (query){
            return "ok";
        }
        model.addAttribute("errer","账号或密码错误");
        return "login";
    }
}
