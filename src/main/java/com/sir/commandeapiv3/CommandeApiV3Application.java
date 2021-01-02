package com.sir.commandeapiv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.sir.commandeapiv3.rest")//parametre le nom du package rest(dans le quel exist feignClient)// 
@SpringBootApplication
public class CommandeApiV3Application {

	public static void main(String[] args) {
		SpringApplication.run(CommandeApiV3Application.class, args);
	}

}

