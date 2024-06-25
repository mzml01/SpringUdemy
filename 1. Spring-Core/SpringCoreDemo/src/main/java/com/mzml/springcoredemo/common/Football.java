package com.mzml.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Football implements Coach{
    public Football(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }
    @PostConstruct
    public void getSomeBean(){
        System.out.println("Bean created "+getClass().getSimpleName());
    }
    @PreDestroy
    public void destSomeBean(){
        System.out.println("Bean Destroyed "+getClass().getSimpleName());
    }
    @Override
    public String dailyWorkout() {
        return "Practice passing for 5 minutes.";
    }

}
