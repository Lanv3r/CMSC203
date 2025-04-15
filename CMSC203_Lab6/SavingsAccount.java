
public class SavingsAccount extends BankAccount {
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;
	public SavingsAccount(String name, double initialAmount) {
		super(name, initialAmount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	public SavingsAccount(SavingsAccount other, double initialAmount) {
		super(other, initialAmount);
        this.savingsNumber = other.savingsNumber + 1;
        accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	public void postInterest() {
		deposit(rate/1200 * getBalance());
	}
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
