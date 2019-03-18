package eu.trumm.HiboDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiboDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HiboDemoApplication.class, args);

		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("Dell");

		Student student = new Student();
		student.setName("Aiki");
		student.setRollno(1);
		student.setMarks(50);
		student.getLaptop().add(laptop);

		laptop.getStudent().add(student);


		Configuration cfg = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(student);
		session.save(laptop);
		session.getTransaction().commit();

	}

}
