package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4NpJeApplication implements CommandLineRunner{
	
	
	@Autowired
	private EstudianteService estudianteService;               //Inyeccion

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4NpJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estudiante miEstudiante=new Estudiante();
		miEstudiante.setApellido("Soria");
		miEstudiante.setCedula("1750982546");
		miEstudiante.setNombre("Nelson");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(2001, 9, 2, 10, 50));
		
		Estudiante miEstudiante2=new Estudiante();
		miEstudiante2.setApellido("Espinosa");
		miEstudiante2.setCedula("1726333196");
		miEstudiante2.setNombre("Joel");
		miEstudiante2.setFechaNacimiento(LocalDateTime.of(1998, 1, 29, 10, 50));
		
		//1. Guardar
		this.estudianteService.guardar(miEstudiante);
		this.estudianteService.guardar(miEstudiante2);
		
		//5.Imprimir reporte
		
		List<Estudiante> report = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte 1 de estudiante");
		for(Estudiante estu: report) {
			System.out.println(estu);
		}
		//2. Actualizar
		miEstudiante.setApellido("Paredes");
		miEstudiante2.setNombre("Santiago");
		this.estudianteService.actualizar(miEstudiante);
		this.estudianteService.actualizar(miEstudiante2);
		
		
		List<Estudiante> report2 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte 2 de estudiante");
		for(Estudiante estu: report2) {
			System.out.println(estu);
		}
		
		//3. Eliminar
		this.estudianteService.borrarPorCedula(miEstudiante2.getCedula());
		
		List<Estudiante> report3 = this.estudianteService.reporteDeTodos();
		System.out.println("Reporte  3 de estudiante");
		for(Estudiante estu: report3) {
			System.out.println(estu);
		}
		
		//4.Buscar
		System.out.println("Busqueda por cedula");
		Estudiante estu=this.estudianteService.buscarPorCedula("1750982546");
		System.out.println(estu);
		
		System.out.println("Busqueda por cedula no existe");
		Estudiante estu1=this.estudianteService.buscarPorCedula("1723282546");
		System.out.println(estu1);
	}

}
