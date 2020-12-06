package com.xoste.leon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Leon
 */
@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo(Model model) {
        System.out.println("执行demo");
        model.addAttribute("model", "人机尼玛的");
        return "/index.jsp";
    }
}
