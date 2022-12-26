package br.edu.ifpi.springflyway;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@Log4j2 @SpringBootApplication
public class SpringFlywayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFlywayApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		log.info("O palmeiras não tem mundial 😰😢");
	}

}
