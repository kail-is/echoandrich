package com.test.echoandrich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EchoandrichApplication {

	public static void main(String[] args) {
		SpringApplication.run(EchoandrichApplication.class, args);
	}

}
