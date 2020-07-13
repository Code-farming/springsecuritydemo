package com.nowcoder.community.controller;

import com.nowcoder.community.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Object object = context.getAuthentication().getPrincipal();
       if (object instanceof User){
           model.addAttribute("LoginUser",object);
       }

        return "/index";
    }

    @RequestMapping(path = "/discuss", method = RequestMethod.GET)
    public String getDiscussPage() {
        return "/site/discuss";
    }

    @RequestMapping(path = "/letter", method = RequestMethod.GET)
    public String getLetterPage() {
        return "/site/letter";
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getAdminPage() {
        return "/site/admin";
    }

    @RequestMapping(path = "/loginpage", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLoginPage() {
        return "/site/login";
    }

    @RequestMapping(path = "/denied", method = {RequestMethod.GET, RequestMethod.GET})
    public String getDeniedPage() {
        return "/error/404";
    }
}
