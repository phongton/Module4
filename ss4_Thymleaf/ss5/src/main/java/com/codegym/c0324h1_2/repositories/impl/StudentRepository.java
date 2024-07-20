package com.codegym.c0324h1_2.repositories.impl;

import com.codegym.c0324h1_2.models.Student;
import com.codegym.c0324h1_2.repositories.IStudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "studentRepository")
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> findAll() {
//        CreateQuery và createNameQuery viết bằng HQL: Hibernate query language
//        NativeQuery: SQL
        List<Student> students = BaseRepository.entityManager.createQuery("select s from student s where name like :name", Student.class).setParameter("name", "%"+ "" +"%").getResultList();
        return students;
    }

    @Override
    public void save(Student student) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
//        Phân biệt persist và merge
        BaseRepository.entityManager.merge(student);
        transaction.commit();
    }
}
