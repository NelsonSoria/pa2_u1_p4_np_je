package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteService {
	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String cedula);

	public void borrarPorCedula(String cedula);
	
	public  List<Estudiante> reporteDeTodos();
}
