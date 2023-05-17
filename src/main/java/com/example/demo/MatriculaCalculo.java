package com.example.demo;

public class MatriculaCalculo {
	public void realizarMatricula(String tipo) {
		if(tipo.equals("1")) {
			Materia mat = new Materia();
			mat.setNombre("pP_web");
			//insertar en la base
			System.out.println("Se inserto materia");
		}else {
			MateriaExtraordinaria matx = new MateriaExtraordinaria();
			matx.setNombre("p_web");
			matx.setCant_creditos(10);
			//insertar en la base
			System.out.println("Se inserto materia extraordinaria");
	}}

}
