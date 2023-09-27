package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.StudentDAO;
import org.nonit.mamnon.service.model.ClassAndGradeOfStudent;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StudentService {
    @Inject
    private StudentDAO studentDAO;

    public ClassAndGradeOfStudent getStudentClassInfo(Integer studentId){
        return studentDAO.getStudentClassInfo(studentId);
    }
}
