package com.example.demo.banco.repository;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;

public interface TransferenciaRepository {


	public void insertarCuenta(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void eliminar(String numero);
	public Transferencia seleccionarPorNumero(String numero);
}
