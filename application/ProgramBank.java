package application;

import java.util.Locale;
import java.util.Scanner;

import util.BankSystem;

public class ProgramBank {
	/*
	 * Enunciado: Em um banco, para se cadastrar uma conta bancária, é necessário
	 * informar o número da conta, o nome do titular da conta, e o valor de depósito
	 * inicial que o titular depositou ao abrir a conta. Este valor de depósito
	 * inicial, entretanto, é opicional, ou seja: Se o titular não tiver dinheiro a
	 * depositar no momento de abrir sua conta, o depósito inicial não será feito e
	 * o saldo inicial da conta será, naturalmente, zero.
	 * 
	 * IMPORTANTE: Uma vez que uma conta bancária foi aberta, o número da conta
	 * nunca poderá ser alterado. Já o nome do titular pode ser alterado (pois uma
	 * pessoa pode mudar de nome por ocasião de casamento, por exemplo).
	 * 
	 * Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver
	 * um mecanismo para proteger isso. O saldo só aumenta por meio de depositos, e
	 * só diminui por meio de saques. Para cada saque realizado o banco cobra uma
	 * taxa de $ 5.00. Nota: A conta pode ficar com saldo negativo se o saldo não
	 * foi suficiente para realizar o saque e/ou pagar a taxa.
	 * 
	 * Você deve fazer um programa que realize o cadastro de uma conta, dando opção
	 * para que seja ou não informado o valor de depósito inicial. Em seguida,
	 * realizar um depósito e depois um saque, sempre mostrando os dados da conta
	 * após cada operação.
	 * 
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome to Banco-Guaxinim!");
		System.out.println(" To register accounts, inform: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Account: ");
		int account = sc.nextInt();
		System.out.println("Do you want to provide an initial balance? (y/n): ");
		char choice = sc.next().charAt(0);
		double balance = 0.00;
		while (true) {
			if (choice == 'Y' || choice == 'y') {
				System.out.println("Enter initial balance: ");
				balance = sc.nextDouble();
				break;
			} else if (choice == 'N' || choice == 'n') {
				break;
			} else {
				System.out.println("Invalid input. Please enter 'y' or 'n'.");
			}
		}
		BankSystem customerOne = (balance != 0.00) ? new BankSystem(account, balance, name)
				: new BankSystem(account, name);
		System.out.print("Success! Name:  " + customerOne.getName());
		System.out.print(" Account: " + customerOne.getAccount());
		System.out.printf(" Balance $ %.2f\n", customerOne.getBalance());
		System.out.println();

		System.out.println("Hello, " + customerOne.getName() + "!" + "\nWhat do you want to do now?\n");

		while (true) {
			System.out.println("\nHow can I help you?");
			System.out.println("1) Remove\n2) Add\n3) Change the name\n4) Anything\n");
			int number = sc.nextInt();
			if (number == 1) {
				System.out.println("Which value do you want to remove? (the fee is $ 5)");
				balance = sc.nextDouble();
				balance = balance + 5.00;
				customerOne.removeValue(balance);
				
			} else if (number == 2) {
				System.out.println("Which value do you want to add?");
				balance = sc.nextDouble();
				customerOne.addValue(balance);
			 } else if (number == 3) {
				System.out.println("What is the new name?");
				name = sc.next();
				customerOne.setName(name);
				System.out.println("Update name: " + customerOne.getName());
				
			} else if (number == 4) {
				System.out.println("GoodBye! =)");
				break;

			} else {
				System.out.println("Invalid, please repeat: ");

			}
		}

		sc.close();

	}

}
