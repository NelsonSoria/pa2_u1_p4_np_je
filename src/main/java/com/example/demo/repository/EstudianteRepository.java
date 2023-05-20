package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	// se busca apartir de un identificador
	public Estudiante seleccionar(String cedula);

	// se elimina por un identificador
	public void eliminar(String cedula);

}
