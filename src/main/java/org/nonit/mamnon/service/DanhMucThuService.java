package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.DanhMucThuDAO;
import org.nonit.mamnon.entity.phieuthu.DanhMucThu;
import org.nonit.mamnon.service.model.DanhMucThuAndDuThu;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DanhMucThuService {

    @Inject
    private DanhMucThuDAO danhMucThuDAO;

    public List<DanhMucThu> getAllDanhMucThu(){
        return danhMucThuDAO.getAllDanhMucThu();
    }

    public List<DanhMucThuAndDuThu> getDanhMucThuAndDuThuOfStudent(Integer studentId, Integer gradeId){
        return danhMucThuDAO.getDanhMucThuAndDuThuOfStudent(studentId, gradeId);
    }
}
