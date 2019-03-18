package eu.trumm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alienAiki = new Alien();
        alienAiki.setAid(101);
        alienAiki.setAname("Aiki");
        alienAiki.setColor("white");

        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(alienAiki);

    }
}
