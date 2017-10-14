/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package junitbook.fine.tasting;

/**
 * @ClassName: AccountManager  
 * @Description: AccountManager 
 * @date 2016-4-16 
 */
public interface AccountManager {
	Account findAccountForUser(String userId);
	void updateAccount(Account account);	
	
}
