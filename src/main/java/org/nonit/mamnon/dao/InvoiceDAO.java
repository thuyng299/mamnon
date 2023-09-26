package org.nonit.mamnon.dao;

import org.nonit.mamnon.entity.phieuthu.Invoice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InvoiceDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;

    public Invoice getInvoiceListOfStudent(Integer studentId, int month, int year){
        return em.createQuery("SELECT i FROM Invoice i " +
                        "WHERE i.student.id = :studentId AND i.month = :month AND i.year = :year", Invoice.class)
                .setParameter("studentId", studentId)
                .setParameter("month", month)
                .setParameter("year", year)
                .getSingleResult();
    }
}
