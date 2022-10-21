package com.cleanArchitecture.fq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mobdev"})
public class MobdevFqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobdevFqApplication.class, args);
	}

}
