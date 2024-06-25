package com.mzml.themleafdemo.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseConstraintValidator implements ConstraintValidator<CoursePrefix,String> {
    public String coursePrefix;
    @Override
    public void initialize(CoursePrefix courseCode) {
        coursePrefix=courseCode.value();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(coursePrefix!=null){
            result=s.startsWith(coursePrefix);
        }else{
            result=true;
        }
        return result;
    }
}
