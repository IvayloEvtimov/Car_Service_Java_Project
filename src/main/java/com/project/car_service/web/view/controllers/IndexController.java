package com.project.car_service.web.view.controllers;

import com.project.car_service.data.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public Object getIndex( Model model) {
        final String welcomeMessage = "Welcome";
//        model.addAttribute("welcome",welcomeMessage);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//      model.addAttribute("username", authentication.getName());

        if(authentication.getPrincipal() == "anonymousUser") {
            return new RedirectView("login");
        }else {
            User principal = (User) authentication.getPrincipal();
            model.addAttribute("username", principal.getUsername());

            return "index";
        }

    }

    @GetMapping("login")
    public String login(Model model) {
        final String welcomeMessage = "Welcome to Car Service System!";
        model.addAttribute("welcome", welcomeMessage);
        return "login";
    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "Welcome to the Car Service System!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }
}
