package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.phieuthu.DanhMucThu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DanhMucThuDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public List<DanhMucThu> getAllDanhMucThu() {
        return this.em.createQuery("SELECT d FROM DanhMucThu d", DanhMucThu.class)
                .getResultList();
    }
}
