package com.mzml.cruddemo;

import com.mzml.cruddemo.dao.StudentDAO;
import com.mzml.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
//        return runner -> {
//            createStudent(studentDAO);
//            System.out.println("Student saved");
//        };
//    }
//
//    private void createStudent(StudentDAO studentDAO) {
//        Student one = new Student("oliver", "giroud", "oligir@gmail.com");
//        studentDAO.saveStudent(one);
//        System.out.println("Student saved");
//        System.out.println("student id :"+one.getId());
//
//    }
}
