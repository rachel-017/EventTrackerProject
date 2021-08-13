package com.skilldistillery.fighters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FightBuddiesApplication extends SpringBootServletInitializer {
	  @Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(FightBuddiesApplication.class);
	  }

	public static void main(String[] args) {
		SpringApplication.run(FightBuddiesApplication.class, args);
	}

}
