package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4NpJeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4NpJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Mi primer proyecto");
		Profesor profe= new Profesor();
		profe.setApellido("Soria"+"  Espinosa");
		profe.setCedula("1750982546"+"  1726333196");
		profe.setFechaNacimiento(LocalDateTime.now());
		profe.setNombre("Nelson"+"  Joel");
		
		System.out.println(profe);
	}

}
