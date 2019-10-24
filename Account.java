package lab4;

public class Account {
	private String name;
	private double balance;
	
	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBal() {
		return balance;
	}
	
	public double withdrawal(double amount) {
		if(amount < balance) {
			balance -= amount;
		}
		return balance;
	}
}
