package com.mytest.tutorial;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junitbook.fine.tasting.Account;
import junitbook.fine.tasting.AccountService;
import junitbook.fine.tasting.MockAccountManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testMultiplication(){
    	Money five = Money.dollar(5);
    	assertEquals(Money.dollar(10),five.times(2));
    	assertEquals(Money.dollar(15),five.times(3));
    }
    
    public void testEquality(){
    	assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    	assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    	assertTrue(Money.franc(5).equals(Money.franc(5)));
    	assertFalse(Money.franc(5).equals(Money.franc(6)));
    	
    	assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }
    
    public void testFrancMultiplication(){
    	Money five = new Franc(5);
    	assertEquals(Money.franc(10),five.times(2));
    	assertEquals(Money.franc(15),five.times(3));
    }
    
    public void testCurrency(){
    	assertEquals("USD",Money.dollar(1).currency());
    	assertEquals("CHF",Money.franc(1).currency());
    }
    
    public void testTransferOk(){
    	MockAccountManager mockAccountManager = new MockAccountManager();
    	Account senderAccount = new Account("1",200);
    	Account beneficiaryAccount = new Account("2",100);
    	
    	mockAccountManager.addAccount("1", senderAccount);
    	mockAccountManager.addAccount("2", beneficiaryAccount);
    	
    	AccountService accountService = new AccountService();
    	accountService.setAccountManager(mockAccountManager);
    	
    	accountService.transfer("1", "2", 50);
    	assertEquals(senderAccount.getBalance(),150);
    	assertEquals(beneficiaryAccount.getBalance(),150);
    	
    }
    
}
