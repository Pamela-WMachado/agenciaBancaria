package Programa;

import Utilitarios.Utils;

public class Conta {
	private static int identificadorDeContas = 1;
	
	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		this.numeroConta = identificadorDeContas;
		this.cliente = cliente;
		identificadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
	public String toString() {
		return "\nNúmero de Conta: " + this.getNumeroConta() +
				"\nNome: " + this.cliente.getNome() + 
				"\nCPF: " + this.cliente.getCpf() + 
				"\nEmail: " + this.cliente.getEmail() + 
				"\nSaldo: " + Utils.doubleToString(this.getSaldo()) + 
				"\n";
	}
	
	public void depositar(Double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Depósito realizado com sucesso!");
		}
		else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}
	
	public void sacar(double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor); 
			System.out.println("Saque realizado com sucesso!");
		}
		else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor); 
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Tranferência realizadoa com sucesso!");
		}else {
			System.out.println("Não foi possível realizar a tranferência.");
		}
	}
	
	public void verSaldo() {
		saldo = this.getSaldo();
		
	}

}
