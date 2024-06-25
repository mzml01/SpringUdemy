package com.mzml.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//        scanBasePackages = {"com.mzml.util",
//                            "com.mzml.springcoredemo"}
//)
@SpringBootApplication
public class SpringCoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreDemoApplication.class, args);
    }

}
