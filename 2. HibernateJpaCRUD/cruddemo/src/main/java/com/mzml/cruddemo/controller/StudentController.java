package com.mzml.cruddemo.controller;

import com.mzml.cruddemo.dao.StudentDAOImpl;
import com.mzml.cruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class StudentController {
    private StudentDAOImpl studentDAO;

    @Autowired
    public StudentController(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return studentDAO.displayStudent();
    }

    @GetMapping()
    public void getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Martin", "Odegaard", "modgrdgmail.com"));
        students.add(new Student("Emile", "Smith", "emilesmithrowe.com"));
        students.add(new Student("Bukayo", "Saka", "bukayosaka.com"));
        students.add(new Student("Gabriel", "Magalhaes", "gabrielmagalhaes.com"));
        students.add(new Student("Thomas", "Partey", "thomaspartey.com"));

        for (Student student : students) {
            studentDAO.saveStudent(student);
        }
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentDAO.findStudent(id);
    }

    @GetMapping("/email/{email}")
    public List<Student> getStudentByEmail(@PathVariable String email) {
        return studentDAO.findEmail(email);
    }

    @GetMapping("/update/{id}")
    public Student update(@PathVariable int id) {
        Student student = studentDAO.findStudent(id);
        student.setFirstName("Pierre");
        student.setLastName("Emerick");
        student.setEmail("aubamabludclat.yang");
        return studentDAO.updateStudent(student);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentDAO.deleteStudent(id);
    }
    @GetMapping("/deleteall")
    public void delete() {
        studentDAO.delete();
    }
}
