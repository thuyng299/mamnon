package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
import org.nonit.mamnon.service.model.DanhMucThuAndDuThu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DanhMucThuDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public List<DanhMucThu> getAllDanhMucThu() {
        return em.createQuery("SELECT d FROM DanhMucThu d", DanhMucThu.class)
                .getResultList();
    }

//    public List<DanhMucThuAndDuThu> getDanhMucThuAndDuThuOfStudent(Integer studentId, Integer gradeId) {
//        return em.createQuery("SELECT NEW org.nonit.mamnon.service.model.DanhMucThuAndDuThu(dm.name, dm.calculationType, " +
//                        "CASE WHEN dt.isMandantory = true THEN dt.amount ELSE 0 END) " +
//                        "FROM DanhMucThu dm " +
//                        "INNER JOIN DuThu dt ON dm.id = dt.danhMucThu.id " +
//                        "WHERE dt.grade.id = :gradeId " +
//                        "AND (dt.isMandantory = true OR EXISTS " +
//                        "(SELECT 1 FROM DangKyMonTuChon dk WHERE dk.duThu.id = dt.id AND dk.student.id = :studentId))", DanhMucThuAndDuThu.class)
//                .setParameter("gradeId", gradeId)
//                .setParameter("studentId", studentId)
//                .getResultList();
//    }
    public List<DanhMucThuAndDuThu> getDanhMucThuAndDuThuOfStudent(Integer studentId, Integer gradeId) {
        return em.createQuery("SELECT NEW org.nonit.mamnon.service.model.DanhMucThuAndDuThu" +
                        "(dm.name, dm.calculationType, dt.amount, dt.id, dt.isMandantory, dm.isAbsentCount, dm.parentId, dm.id) " +
                        "FROM DanhMucThu dm " +
                        "INNER JOIN DuThu dt ON dm.id = dt.danhMucThu.id " +
                        "WHERE dt.grade.id = :gradeId " +
                        "AND (dt.isMandantory = true OR EXISTS ( " +
                        "SELECT 1 FROM DangKyMonTuChon dk " +
                        "WHERE dk.duThu.id = dt.id AND dk.student.id = :studentId))", DanhMucThuAndDuThu.class)
                .setParameter("gradeId", gradeId)
                .setParameter("studentId", studentId)
                .getResultList();
    }


}

