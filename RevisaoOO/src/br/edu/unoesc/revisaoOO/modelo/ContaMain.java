package br.edu.unoesc.revisaoOO.modelo;

import java.time.LocalDate;

public class ContaMain {

	public static void main(String[] args) {
		//Cliente 1
		Cliente cliente = new Cliente("André", "9999",
				LocalDate.of(2000, 10, 30));
		Conta conta1 = new Conta(123, cliente);
		conta1.depositar(150.0);
		conta1.sacar(30.0);
		System.out.printf("Conta %s saldo = %.2f ", conta1.getCliente().getNome(), conta1.getSaldo());
		System.out.println();
		
		//Cliente 2
		Cliente clienteJoaquim = new Cliente("Joaquim", "8888", 
				LocalDate.of(1980, 10, 30));
		Conta conta2 = new Conta(123, clienteJoaquim);
		conta2.depositar(100.0);
		conta2.sacar(10.0);
		System.out.printf("Conta %s saldo = %.2f", conta2.getCliente().getNome(), conta2.getSaldo());
		System.out.println();
		conta1.transferir(20.0, conta2);
		System.out.printf("Conta %s saldo = %.2f ", conta1.getCliente().getNome(), conta1.getSaldo());
		System.out.println();
		System.out.printf("Conta %s saldo = %.2f", conta2.getCliente().getNome(), conta2.getSaldo());
		
		CalculadoraSaldo calculadoraSaldo = new CalculadoraSaldo();
		calculadoraSaldo.addConta(conta1);
		calculadoraSaldo.addConta(conta2);
		System.out.println(calculadoraSaldo.calcular());
		

	}
}
