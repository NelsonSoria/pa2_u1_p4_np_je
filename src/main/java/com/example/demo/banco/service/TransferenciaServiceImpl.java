package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private CuentaRepository cuentaRepository;

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

	@Override
	public void realizar(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		//1. Consultar la cuenta de origen por el numero de Cuenta
		Cuenta ctaOrigen=this.cuentaRepository.seleccionarPorNumero(numeroCtaOrigen);
		
		//2. Consultar el saldo de la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		//3. Validar si el saldo es suficiente
		if(monto.compareTo(saldoOrigen)<=0) {// si es menor que 0, entonces monto es <=saldoOrigen
			//5. Si si es suficiente ir al paso 6
			//6. Realizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen=saldoOrigen.subtract(monto); //RESTA
			
			//7. Actualizamos el nuevo saldo de la cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);
			
			//8. Consultamos la cuenta de destino por el numero de Cuenta
			Cuenta ctaDestino=this.cuentaRepository.seleccionarPorNumero(numeroCtaDestino);
			
			//9. Consultamos el saldo de la cuenta destino
			BigDecimal saldoDestino = ctaDestino.getSaldo();
			
			//10. Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
			//11. Actualizamos el nuevo saldo de la cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepository.actualizar(ctaDestino);
			//12. Creamos el registro(transferencia)
			Transferencia transfer = new Transferencia();
			transfer.setCuentaDestino(ctaDestino);
			transfer.setCuentaOrigen(ctaOrigen);
			transfer.setMonto(monto);
			Double numero= Math.random();
			transfer.setNumero(numero.toString());
			transfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertarCuenta(transfer);
			
			System.out.println("TRANSFERENCIA EXITOSA");
			
		}else {
			//4. Si no es suficiente imprimir mensaje de no haya saldo suficiente
			System.out.println("Saldo no disponible, su saldo es: "+saldoOrigen);
		}
		
	}
	

}
