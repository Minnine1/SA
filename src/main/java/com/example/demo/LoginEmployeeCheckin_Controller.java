package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginEmployeeCheckin_Controller {

    @RequestMapping(value = "/loginEmpCheck")
    public String index() {
        return "index";
    }
}