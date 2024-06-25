package com.mzml.springcoredemo.rest;

import com.mzml.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dailyWorkout")
public class DemoController {
    private Coach myCoach;
    @Autowired
    public void setCoach(@Qualifier("arsenal") Coach myCoach){
        System.out.println("In Constructor : "+getClass().getSimpleName());
        this.myCoach=myCoach;
    }

    @GetMapping
    public String getDailyWorkout(){
        return myCoach.dailyWorkout();
    }

}
