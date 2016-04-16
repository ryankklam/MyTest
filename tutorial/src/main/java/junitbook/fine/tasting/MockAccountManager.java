/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package junitbook.fine.tasting;

import java.util.Hashtable;

/**
 * @ClassName: MockAccountManager  
 * @Description: TODO(Override class description here)  
 * @date 2016-4-16 
 */
public class MockAccountManager implements AccountManager{

	private Hashtable accounts = new Hashtable(); 
	
	/* (non-Javadoc)
	 * @see junitbook.fine.tasting.AccountManager#findAccountForUser(java.lang.String)
	 */
	public Account findAccountForUser(String userId) {
		return (Account) this.accounts.get(userId);
	}

	/* (non-Javadoc)
	 * @see junitbook.fine.tasting.AccountManager#updateAccount(junitbook.fine.tasting.Account)
	 */
	public void updateAccount(Account account) {
		// do nothing
		
	}
	
	public void addAccount(String userId, Account account){
		this.accounts.put(userId, account);
	}

}
