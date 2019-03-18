package eu.trumm.h2;

import eu.trumm.h2.domain.Subscriber;
import eu.trumm.h2.domain.SubscriberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2Application {

	public static void main(String[] args) {

		SpringApplication.run(H2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(SubscriberRepository repository) {
		return args -> {
			repository.save(new Subscriber("Aiki", "Trumm", "aiki@trumm.eu"));
		};

	}

}
