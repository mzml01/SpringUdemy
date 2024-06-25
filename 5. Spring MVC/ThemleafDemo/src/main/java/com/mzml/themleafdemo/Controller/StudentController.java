package com.mzml.themleafdemo.Controller;

import com.mzml.themleafdemo.Model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${csLanguages}")
    private List<String> csLanguages;

    @GetMapping("/showForm")
    public String confirmData(Model theModel){
        Student theStudent= new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("csLanguages", csLanguages);
        return "student-form";
    }
    @PostMapping("/processForm")
    public String processFrom(@Valid @ModelAttribute("student") Student theStudent, BindingResult thBindingresult){
        if(thBindingresult.hasErrors()){
            System.out.println("Error : "+ thBindingresult.toString());
            return "student-form";
        }
        else {
            return "student-confirmation";
        }
    }
    @InitBinder
    public void intiBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}
