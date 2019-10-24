package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestBank {
	private static Bank myBank;
	private static Scanner sc;
	
	public static void main(String[] args) {
		myBank = new Bank();
		sc = new Scanner(System.in);
		
		try {
			System.out.println("How many account R U gonna input?");
			int accNum = sc.nextInt();
			
			getInputs(accNum);
			
			showAccoutns();
			
			for(Account acc : myBank.getAccounts()) {
				System.out.println(acc.getName() + "has " + acc.getBal());
			}
			
		} catch(InputMismatchException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static void showAccoutns() {
		// TODO Auto-generated method stub
		
	}

	private static void getInputs(int accNum) {
		for(int i = 0; i < accNum; i++) {
			System.out.println("Input acc Name");
			String name = sc.nextLine();
			System.out.println("Input balance of " + name);
			Double bal = sc.nextDouble();
			myBank.addAcct(name, bal);
		}
	}
}
