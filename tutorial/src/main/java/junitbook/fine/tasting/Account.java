/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package junitbook.fine.tasting;

/**
 * @ClassName: Account  
 * @Description: TODO(Override class description here)  
 * @date 2016-4-16 
 */
public class Account {
	private String accountId;
	private long balance;
	
	public Account(String accountId, long balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}
	
	public void debit(long amount){
		this.balance-=amount;
	}
	
	public void credit(long amount){
		this.balance+=amount;
	}
	
	public long getBalance(){
		return this.balance;
	}
	
	
	
}
