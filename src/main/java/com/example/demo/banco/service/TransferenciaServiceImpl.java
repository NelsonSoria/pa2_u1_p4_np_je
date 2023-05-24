package com.example.demo.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.repository.modelo.Estudiante;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepository.insertarCuenta(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		this.transferenciaRepository.eliminar(numero);
		
	}

	@Override
	public Transferencia buscarPorNumero(String numero) {
		
		return this.transferenciaRepository.seleccionarPorNumero(numero);
	}
	

}
