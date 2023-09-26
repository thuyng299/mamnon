package org.nonit.mamnon.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CongDoanDAO {

    @PersistenceContext(name = "mamnon")
    private EntityManager em;


}
