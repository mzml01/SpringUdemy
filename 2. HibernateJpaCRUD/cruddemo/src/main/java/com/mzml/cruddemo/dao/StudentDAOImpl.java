package com.mzml.cruddemo.dao;

import com.mzml.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
{
    private EntityManager entityManager;
@Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Student> saveStudent(Student student) {
        entityManager.persist(student);
        return null;
    }

    @Override
    public Student findStudent(int id) {
        return entityManager.find(Student.class,id);
    }

    public List<Student> displayStudent() {
        return entityManager.createQuery("from Student order by firstName",Student.class).getResultList();
    }

    @Override
    public List<Student> findEmail(String email) {
        return entityManager.createQuery("from Student where email like :email",Student.class)
                .setParameter("email","%"+email)
                .getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        entityManager.createQuery("delete from Student where id=:id")
                .setParameter("id",id)
                .executeUpdate();
        entityManager.createQuery("UPDATE Student set id=id-1 where id>:id")
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete() {
        entityManager.createQuery("delete from Student").executeUpdate();
    }
}
