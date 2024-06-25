package com.mzml.springrest.Controller;

import com.mzml.springrest.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    public List<Student> students;
    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("John","Doe"));
        students.add(new Student("Jane","mayer"));
        students.add(new Student("John","Smith"));
    }
    @GetMapping ("/students/{id}")
    public Student getStudent(@PathVariable int id){
        if(id>=students.size()||id<0){
            throw new StudentNotFoundException("Student id not found - "+id);
        }
        return students.get(id);
    }
}
