/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package com.mytest.tutorial;

/**
 * @ClassName: Dollar  
 * @Description: Dollar
 * @date 2016-4-10 
 */
public class Dollar extends Money {


	/**
	 * @param amount
	 */
	public Dollar(int amount) {
		super(amount);
		currency="USD";
	}

	/**
	 * @param i
	 */
	public Money times(int multiplier) {
		return new Dollar(amount*multiplier);
		
	}
}
