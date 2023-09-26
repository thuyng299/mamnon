package org.nonit.mamnon.service;

import org.nonit.mamnon.dao.DanhMucThuDAO;
import org.nonit.mamnon.entity.phieuthu.DanhMucThu;

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
}
