package ru.pr13.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.pr13.beans")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
