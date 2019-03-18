package eu.trumm.DemoHibSpring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHibSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoHibSpringApplication.class, args);

		AlienName anameAiki = new AlienName();
		anameAiki.setFirstName("Aiki");
		anameAiki.setLastName("Trumm");
		anameAiki.setMiddleName("B.");


		Alien alienAiki = new Alien();
		alienAiki.setAid(101);
		alienAiki.setAname(anameAiki);
		alienAiki.setColor("white");


		Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(alienAiki);
		tx.commit();

	}

}
