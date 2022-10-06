package br.com.mefit.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableJpaRepositories("br.com.mefit.domain.infrastructure.repository")
@ComponentScan(basePackages = {"br.com.mefit.domain"})
public class MeFitUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeFitUserApplication.class, args);
	}

}
