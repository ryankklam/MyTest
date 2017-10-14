/**
 *  @Author: 	Ryan K K Lam
 *  @Links: 	https://github.com/ryankklam
 *  @Email: 	ryan4299899@126.com
 *
 */
package com.mytest.tutorial;

/**
 * @ClassName: Franc  
 * @Description: Franc
 * @date 2016-4-10 
 */
public class Franc extends Money{


	/**
	 * @param amount
	 */
	public Franc(int amount) {
		super(amount);
		currency="CHF";
	}


	/**
	 * @param i
	 */
	public Money times(int multiplier) {
		return new Franc(amount*multiplier);
		
	}

	
}
