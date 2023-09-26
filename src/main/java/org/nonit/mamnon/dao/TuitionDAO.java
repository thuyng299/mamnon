package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.phieuthu.Tuition;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Stateless
public class TuitionDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public List<Tuition> getInvoiceDetailListByInvoice(Long invoiceId) {
       return em.createQuery("SELECT t FROM Tuition t " +
              "WHERE t.invoice.id = :invoiceId", Tuition.class)
              .setParameter("invoiceId", invoiceId)
              .getResultList();
    }
}
