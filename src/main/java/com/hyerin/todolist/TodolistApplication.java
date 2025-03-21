package com.hyerin.todolist;

import lombok.extern.log4j.Log4j2;
import lombok.extern.log4j.Log4j2.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class TodolistApplication {

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Value("${server.port}")
	private String serverPort;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			if (log.isDebugEnabled()) { log.debug("localhost: {}{}" , serverPort , contextPath ); }
		};
	}
}
