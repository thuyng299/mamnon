package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.congdoan.CongDoan;
import org.nonit.mamnon.entity.mamnon.Student;
import org.nonit.mamnon.service.model.ClassAndGradeOfStudent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class StudentDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public Optional<Student> getById(Integer studentId) {
        List<Student> studentList = em.createQuery("SELECT s FROM Student s " +
                        "WHERE s.id = :studentId", Student.class)
                .setParameter("studentId", studentId)
                .getResultList();

        return studentList.isEmpty() ? Optional.empty() : Optional.of(studentList.get(0));
    }

    public Integer getCongDoanByStudentId(Integer studentId) {
        return em.createQuery("SELECT cd.id FROM CongDoan cd, Grade g, Clazz c, Student s " +
                "WHERE cd.id = g.congdoan.id AND g.id = c.grade.id AND c.id = s.clazz.id " +
                "AND s.id = :studentId")
                .setParameter("studentId", studentId)
                .getFirstResult();
    }

    public ClassAndGradeOfStudent getStudentClassInfo(Integer studentId){
        return em.createQuery("SELECT NEW org.nonit.mamnon.service.model.ClassAndGradeOfStudent(s.id, s.firstName, s.lastName, c.id, g.id, cd.id) " +
                "FROM Student s, Clazz c, Grade g, CongDoan cd " +
                "WHERE s.clazz.id = c.id AND c.grade.id = g.id AND g.congdoan.id = cd.id AND s.id = :studentId", ClassAndGradeOfStudent.class)
                .setParameter("studentId", studentId)
                .getSingleResult();
    }
}