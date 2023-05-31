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

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4NpJeApplication implements CommandLineRunner{
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4NpJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Cuenta 1
		Cuenta cta1= new Cuenta();
		cta1.setCedulaPropietario("1750982546");
		cta1.setFechaApertura(LocalDate.now());
		cta1.setNumero("001");
		cta1.setSaldo(new BigDecimal(200));
		cta1.setTipo("A");
		
		//Cuenta 2
		Cuenta cta2= new Cuenta();
		cta2.setCedulaPropietario("17263331969");
		cta2.setFechaApertura(LocalDate.now());
		cta2.setNumero("002");
		cta2.setSaldo(new BigDecimal(600));
		cta2.setTipo("A");
		
		
		this.cuentaService.guardar(cta1);
		this.cuentaService.guardar(cta2);
		

		this.transferenciaService.realizar(cta1.getNumero(), cta2.getNumero(), new BigDecimal(60));	

		this.transferenciaService.realizar(cta2.getNumero(), cta1.getNumero(), new BigDecimal(100));	
		
		
		System.out.println("Saldo Origen: "+    this.cuentaService.buscarPorNumero(cta1.getNumero()).getSaldo());
		System.out.println("Saldo Destino: "+    this.cuentaService.buscarPorNumero(cta2.getNumero()).getSaldo());
		
		
		List<Transferencia> estadoCuenta= this.transferenciaService.buscarTodo();
		
	
		System.out.println("\n****************REPORTE TODAS LAS TRANSFERENCIAS**************\n");
	
		
		for(Transferencia transf : estadoCuenta) {
			System.out.println("  Numero de Transferencia: "+transf.getNumero()
					+"  Num CtaOrigen: "+transf.getCuentaOrigen().getNumero()
					+"  Num CtaDestino: "+transf.getCuentaDestino().getNumero()
					+"  Fecha: "+transf.getFecha());
		}
		
	
		
		
	}

}
