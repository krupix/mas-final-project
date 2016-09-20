package pl.krupix.mas.finalproject.model;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import pl.krupix.mas.finalproject.model.domain.AdressData;
import pl.krupix.mas.finalproject.model.domain.Warehouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by krupix on 18.06.2016.
 */
public class HibernateUtil {

    private static Logger log =  Logger.getLogger(HibernateUtil.class);

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private EntityManager entityManager;

    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().addPackage("pl.krupix.mas.finalproject").addAnnotatedClass(Warehouse.class).addAnnotatedClass(AdressData.class).configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }


}
