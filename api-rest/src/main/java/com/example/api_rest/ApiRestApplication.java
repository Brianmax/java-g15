package com.example.api_rest;

import com.example.api_rest.entity.ArticuloEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		ArticuloEntity articuloEntity = new ArticuloEntity();
	}

}
