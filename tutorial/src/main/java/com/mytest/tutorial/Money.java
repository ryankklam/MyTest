/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package com.mytest.tutorial;

/**
 * @ClassName: Money  
 * @Description: TODO(Override class description here)  
 * @date 2016-4-11 
 */
public abstract class Money {
	protected int amount;
	protected String currency;
	
	abstract Money times(int multiplier);
	String currency(){
		return currency;
	}

	public Money(int amount) {
		this.amount = amount;
	}
	
	public boolean equals(Object object){
		Money money = (Money)object;
		return this.amount == money.amount &&getClass().equals(money.getClass());
	}
	
	static Money dollar(int amount){
		return new Dollar(amount);
	}
	
	static Money franc(int amount){
		return new Franc(amount);
	}

}
