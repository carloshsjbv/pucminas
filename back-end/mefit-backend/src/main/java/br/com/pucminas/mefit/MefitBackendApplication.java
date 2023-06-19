package br.com.pucminas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MefitBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MefitBackendApplication.class, args);
	}

}
