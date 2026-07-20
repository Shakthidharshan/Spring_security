package com.shakthi.Springsecurity;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public  String greet(HttpServletRequest request){
        System.out.println("welcome to home page");
        System.out.println("this a java project");
        return "welcome to home page " + request.getSession().getId();

    }

}
