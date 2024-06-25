package com.mzml.themleafdemo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    @RequestMapping("/source")
    public String helloWorld() {
        return "helloworld-html";
    }
    @RequestMapping("/source2")
    public String helloWorld2() {
        return "helloworld";
    }
//    @RequestMapping("/source3")
//    public String helloWorld3(HttpServletRequest request, Model model) {
//        String studentName= request.getParameter("studentName");
//        studentName= studentName.toUpperCase();
//        String result= "Yo! "+studentName;
//        model.addAttribute("message", result);
//        return "helloworld";
//    }
    @RequestMapping("/source3")
    public String helooWorld3(@RequestParam("studentName") String theName,Model model){
        theName= theName.toUpperCase();
        String result= "Yo! "+theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
