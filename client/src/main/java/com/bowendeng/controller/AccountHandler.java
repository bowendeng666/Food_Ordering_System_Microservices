package com.bowendeng.controller;

import com.bowendeng.entity.Admin;
import com.bowendeng.entity.User;
import com.bowendeng.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap) accountFeign.login(username, password, type);
        String result = null;
        if (hashMap == null){
            result = "login";
        }else{
            switch (type){
                case "user":
                    User user = new User();
                    user.setId((int)hashMap.get("id"));
                    user.setNickname((String)hashMap.get("nickname"));
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    admin.setId((int)hashMap.get("id"));
                    admin.setUsername((String)hashMap.get("username"));
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
