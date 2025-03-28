package com.hyerin.todolist;

import com.hyerin.todolist.common.utils.CommonUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			if (log.isDebugEnabled()) {
				log.debug("localhost: {}{}" , CommonUtils.getServerPort() , CommonUtils.getContextPath() );
                log.debug("{}:{}{}", CommonUtils.getServerIP(), CommonUtils.getServerPort(), CommonUtils.getContextPath());
				log.debug("서버 구동이 시작되었습니다.");
			}
		};
	}

}
