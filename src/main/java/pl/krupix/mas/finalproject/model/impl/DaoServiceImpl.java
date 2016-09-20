package pl.krupix.mas.finalproject.model.impl;

import pl.krupix.mas.finalproject.model.DaoSerivce;
import pl.krupix.mas.finalproject.model.domain.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by krupix on 17.06.2016.
 */
public class DaoServiceImpl implements DaoSerivce {

    private EntityManager em;

    public DaoServiceImpl() {
        init();
    }

    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PGAutoService");
        em = emf.createEntityManager();
    }

    @Override
    public void persist(Object domain) {
        em.getTransaction().begin();
        em.persist(domain);
        em.getTransaction().commit();
    }

    public List<Warehouse> getAllWarehouses() {
        Query query = em.createQuery("SELECT w FROM Warehouse w");
        return (List<Warehouse>) query.getResultList();
    }

}
