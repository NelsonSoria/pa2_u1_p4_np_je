package com.example.demo.banco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;


@Service
public class CuentaServiceImpl implements CuentaService{
	
	@Autowired
	CuentaRepository cuenta ;

	@Override
	public void guardar(Cuenta cuenta) {
		this.cuenta.insertarCuenta(cuenta);
		
	}

	@Override
	public void actualizar(Cuenta cuenta) {
		this.cuenta.actualizar(cuenta);
		
	}

	@Override
	public void eliminar(String numero) {
		this.cuenta.eliminar(numero);
		
	}

	@Override
	public Cuenta buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuenta.seleccionarPorNumero(numero);
	}
	

}
