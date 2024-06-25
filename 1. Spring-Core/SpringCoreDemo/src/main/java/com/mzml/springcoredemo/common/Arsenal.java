package com.mzml.springcoredemo.common;

public class Arsenal implements Coach{
    public Arsenal(){
        System.out.println("the Constructor : "+getClass().getSimpleName());
    }
//    public String arsenal(){
//        return "Best club in london, And best in europe currently";
//    }

    @Override
    public String dailyWorkout() {
        return "Best club in london, And best in europe currently";
    }
}
