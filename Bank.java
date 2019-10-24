package lab4;

public class Bank {
	private Account[] acct;
	private int n;
	
	public Bank() {
		n = 0;
		acct = new Account[100];
	}
	
	public void addAcct(String nm, double bal) {
		acct[n] = new Account(nm, bal);
	}
	
	public Account findAcct(String nm) {
		for(int i = 0; i < n; i++) {
			if(acct[i].getName().equals(nm)) {
				return acct[i];
			}
		}
		return null;
	}
	
	public Account[] getAccounts() {
		return acct;
	}
}
