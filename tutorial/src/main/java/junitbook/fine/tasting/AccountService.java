/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package junitbook.fine.tasting;

/**
 * @ClassName: AccountService  
 * @Description: TODO(Override class description here)  
 * @date 2016-4-16 
 */
public class AccountService {
	private AccountManager accountManager;

	/**
	 * @return the accountManager
	 */
	public AccountManager getAccountManager() {
		return accountManager;
	}

	/**
	 * @param accountManager the accountManager to set
	 */
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	public void transfer(String sendId,String beneficiaryId,long amount){
		Account sender = this.accountManager.findAccountForUser(sendId);
		Account beneficiary = this.accountManager.findAccountForUser(beneficiaryId);
		
		sender.debit(amount);
		beneficiary.credit(amount);
		
		this.accountManager.updateAccount(sender);
		this.accountManager.updateAccount(beneficiary);
	}
}
