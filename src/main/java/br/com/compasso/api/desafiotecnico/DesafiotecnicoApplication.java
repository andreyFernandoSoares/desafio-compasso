package br.com.compasso.api.desafiotecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DesafiotecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiotecnicoApplication.class, args);
	}

}
