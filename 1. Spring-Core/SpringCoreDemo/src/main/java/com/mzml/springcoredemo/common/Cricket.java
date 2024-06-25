package com.mzml.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class Cricket implements Coach{
    public Cricket(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "practice fast bowling for 15 min";
    }
}
