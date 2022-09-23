package Programa;

import java.util.ArrayList;
import java.util.Scanner;

import Utilitarios.Utils;

public class AgenciaBancaria {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}
	
	public static void operacoes() {
		System.out.println("-------------------------------------------------");
		System.out.println("----------Bem-vindo(a) a nossa agência-----------");
		System.out.println("-------------------------------------------------");
		System.out.println("*****Selecione a operação que deseja realizar*****");
		System.out.println("-------------------------------------------------");
		System.out.println("|  Opção 1 - Criar conta  |");
		System.out.println("|  Opção 2 - Depositar    |");
		System.out.println("|  Opção 3 - Sacar        |");
		System.out.println("|  Opção 4 - Transferir   |");
		System.out.println("|  Opção 5 - Ver saldo    |");
		System.out.println("|  Opção 6 - Listar Contas|");
		System.out.println("|  Opção 7 - Sair         |");

		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			verSaldo();
			break;
		case 6:
			listar();
			break;
		case 7:
			System.out.println("Operação finalizada");
			System.exit(operacao);
			
			default: 
				System.out.println("Opção Inválida");
				operacoes(); //chamando o menu de operaçoes novamente 
				break;
		}
	}
	
	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = input.next();
		
		System.out.println("\nCPF: ");
		String cpf = input.next();
		
		System.out.println("\nEmail: ");
		String email = input.next();
		
		Cliente cliente = new Cliente(nome, cpf, email);
		
		Conta conta = new Conta(cliente);
		contasBancarias.add(conta);
		System.out.println("Conta criada com sucesso!");
		
		operacoes();
	}
	
	//metodo que verifica se a conta existe, que sera usado nas operaçoes a seguir 
	private static Conta encontrarConta(int numConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numConta) {
					conta = c;

				}
			}
		}
		return conta;
	}
	public static void depositar() {
		System.out.println("Informe número da conta: ");
		int numConta = input.nextInt();
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Valor do depósito: ");
			Double valorDeposito = input.nextDouble();
			conta.depositar(valorDeposito);
		}
		else {
			System.out.println("Conta inválida. Tente novamente.");
			
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("Informe número da conta: ");
		int numConta = input.nextInt();
		
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {
			System.out.println("Valor do saque: ");
			Double valorSaque = input.nextDouble();
			conta.sacar(valorSaque);
		}
		else {
			System.out.println("Conta inválida. Tente novamente.");
			
		}
		operacoes();
	}
	
	public static void transferir() {
		System.out.println("Conta remetente: ");
		int numContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numContaRemetente);
		if (contaRemetente != null) {
			System.out.println("Conta destinarário: ");
			int numContaDestinatario = input.nextInt();
			
			Conta contaDestinatinario = encontrarConta(numContaDestinatario);
			if(contaDestinatinario != null) {
				System.out.println("Valor a ser transferido: ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatinario, valor);
			}
		else {
            System.out.println("--- A conta do destinatário não foi encontrada ---");
        }

    }else {
        System.out.println("--- A Conta remetente não foi encontrada ---");
    }
		operacoes();
	}
	
	
	public static void verSaldo() {
		System.out.println("Informe número da conta: ");
		int numConta = input.nextInt();
		Conta conta = encontrarConta(numConta);
		
		if(conta != null) {

			System.out.println("Saldo: " +  Utils.doubleToString(conta.getSaldo()));
		}
		else {
			System.out.println("Conta inválida. Tente novamente.");
			
		}
		operacoes();
	} 
	
	public static void listar() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Não há contas cadastradas.");
		}
		operacoes();
	}
	
}
