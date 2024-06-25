package com.mzml.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class Tennis implements Coach{
    public Tennis(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "practice serving for 30m";
    }
}
