package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.thuchimamnon.DanhMucChiMamNon;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DanhMucChiMamNonDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public List<DanhMucChiMamNon> findAll() {
        return this.em.createQuery("SELECT d FROM DanhMucChiMamNon d", DanhMucChiMamNon.class)
                .getResultList();
    }
}
