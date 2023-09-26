package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.ClazzDAO;
import org.nonit.mamnon.service.model.ClassAndStudentList;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ClazzService {

    @Inject
    private ClazzDAO clazzDAO;

    public List<ClassAndStudentList> getClassListOfGradeInAcademicYear(Integer congDoanId, Integer gradeId, String academicYear){
        return clazzDAO.getClassListOfGradeInAcademicYear(congDoanId, gradeId, academicYear);
    }
}
