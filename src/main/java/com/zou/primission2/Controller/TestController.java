package com.zou.primission2.Controller;

import com.zou.primission2.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class TestController {


    @RequestMapping("/login")
    public String login() {

        return "login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {

        return "admin success";
    }

    @RequestMapping("/logout")
    public String logout() {

        Subject subject = SecurityUtils.getSubject();

        if (subject != null) {
            subject.logout();
        }

        return "login";
    }


    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            HttpSession httpSession) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            httpSession.setAttribute("user", user);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();

            return "login";
        }


    }


}


















