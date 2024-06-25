package com.mzml.cruddemo.dao;

import com.mzml.cruddemo.entity.Student;
import uz.khurozov.jokeapi.JokeApi;

import java.util.List;

public interface StudentDAO {
    public List<Student> saveStudent(Student student);
    public Student findStudent(int id);
    public List<Student> displayStudent();
    public List<Student> findEmail(String email);

    public Student updateStudent(Student student);
    public void deleteStudent(int id);
    public void delete();
}
