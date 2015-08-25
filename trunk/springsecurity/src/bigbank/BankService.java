package bigbank;

public interface BankService {

	public Account readAccount(Long id);

	public Account[] findAccounts();

	public Account post(Account account, double amount);
}
