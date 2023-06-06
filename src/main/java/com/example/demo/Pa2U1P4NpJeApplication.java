package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4NpJeApplication implements CommandLineRunner{
	@Autowired
	private Cajero cajero;
	@Autowired
	private Cajero cajero2;	
	@Autowired
	private Presidente presidente;
	@Autowired
	private Presidente presidente2;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4NpJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		this.cajero.setApellido("Espinosa");
		this.cajero.setNombre("Joel");
		this.cajero.setSalario(new BigDecimal(100));
		
		this.cajero2.setApellido("Soria");
		this.cajero2.setNombre("Nelson");
		this.cajero2.setSalario(new BigDecimal(200));
		
		this.presidente.setApellido("Porras");
		this.presidente.setNombre("Andrea");
		this.presidente.setCedula("cedula");
		
		this.presidente2.setApellido("Taco");
		
		System.out.println(this.presidente);
		System.out.println(this.presidente2);
		
		System.out.println(this.cajero);
		System.out.println(this.cajero2);
		System.out.println(this.cajero2.getApellido());
		
		
		System.out.println("*********************SEGUNDA PARTE******");
		this.cargaSistemaService.cargar();
		
		Transferencia trans = new Transferencia();
		trans.setCuentaDestino(null);
		trans.setCuentaOrigen(null);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(new BigDecimal(100));
		trans.setNumero("132165");
		
		this.transferenciaService.guardar(trans);
		
		
	}

}
