package pl.krupix.mas.finalproject.service.starter;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.krupix.mas.finalproject.model.HibernateUtil;
import pl.krupix.mas.finalproject.model.domain.AdressData;
import pl.krupix.mas.finalproject.model.domain.Warehouse;
import pl.krupix.mas.finalproject.service.MainService;
import pl.krupix.mas.finalproject.service.impl.MainServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by krupix on 13.06.2016.
 */
public class ServiceStarter {


    public static void main(String[] args) {
        initLog4J();
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("service-ctx.xml");
//        MainService service = (MainService) ctx.getBean("mainService");
//        HibernateUtil.getSessionFactory();
        MainServiceImpl mainService = new MainServiceImpl();

    }

    private static void initLog4J() {
        String log4jConfPath = "log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }

}
