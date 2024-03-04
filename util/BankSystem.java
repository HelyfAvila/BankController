package util;

public class BankSystem {
	private int account;
	private Double balance;
	private String name;
	public BankSystem(int account, Double balance, String name) {
		this.account = account;
		this.balance = balance;
		this.name = name;
	}
	public BankSystem(int account, String name) {
		this.account = account;
		this.name = name;
		this.balance = 0.00;
	}
	public BankSystem() {
		
	}
	public int getAccount() {
		return account;
	}
	public Double getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void removeValue(double balance) {
		this.balance -= balance;
		System.out.println("Extract: Removed $ "+ balance + "\nRemaining value $ "+  this.balance);
	}
	public void addValue(double balance) {
		this.balance += balance;
		System.out.println("Extract: Add $" + balance + "\nNew value $ " + this.balance);
	}
	
	
}
