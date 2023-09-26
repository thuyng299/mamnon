package org.nonit.mamnon.dao;

import org.nonit.mamnon.service.model.ClassAndStudentList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClazzDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public List<ClassAndStudentList> getClassListOfGradeInAcademicYear(Integer congDoanId, Integer gradeId, String academicYear) {
        return em.createQuery("SELECT NEW org.nonit.mamnon.service.model.ClassAndStudentList(c.id, c.className, count(s.id), g.id, g.name, g.academicYear) " +
                        "FROM Grade g, Clazz c, Student s WHERE g.id = c.grade.id AND c.id = s.clazz.id " +
                        "AND g.congdoan.id = :congDoanId AND g.id = :gradeId AND g.academicYear = :academicYear " +
                        "GROUP BY c.id, c.className, s.clazz.id, g.id, g.name, g.academicYear " +
                        "ORDER BY c.id", ClassAndStudentList.class)
                .setParameter("congDoanId", congDoanId)
                .setParameter("gradeId", gradeId)
                .setParameter("academicYear", academicYear)
                .getResultList();
    }
}