package com.clearent.creditcardinterest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardInterestTest {

    @Mock
    private CreditCardInterestCal creditCardInterestCal;
    
/**
Now write a program program that calculates Credit Card interest for a Person.  
 
Visa gets 10%
MC gets 5% interest
Discover gets 1% interest
 
Each Card Type can have multiple cards and there can be multiple Wallets for a Person. 
 
NOTE:  SIMPLE INTEREST for this test case (means 1 month of interest, if the interest rate is 10% and the amount is 100.00 – interest in this case would be 10.00) 

Here are the test Cases
*/

// 1 person has 1 wallet and 3 cards (1 Visa, 1 MC 1 Discover) – Each Card has a balance of $100 – calculate the total interest (simple interest) for this person and per card. 

    @Test
    public void test1() {
    	
    	Float totalInterest = new Float(100*0.1+100*0.05+100*0.01);
    	List<Float> interestPercard = new ArrayList<Float>();
    	interestPercard.add(new Float(100.*0.1));
    	interestPercard.add(new Float(100*0.05));
    	interestPercard.add(new Float(100*0.01));
    	Response response = new Response();
    	response.setTotalInterest(totalInterest);
    	response.setInterestPercard(interestPercard);
    	List<Response> responseLst = new ArrayList<Response>();
    	responseLst.add(response);
    	
        when(creditCardInterestCal.calculate(any(Request.class))).thenReturn(responseLst);
        assertNotNull(responseLst);
    }
    
// 1 person has 2 wallets  Wallet 1 has a Visa and Discover , wallet 2 a MC -  each card has $100 balance - calculate the total interest(simple interest) for this person and interest per wallet

    @Test
    public void test2() {
    	
    	Float totalInterest = new Float(100*0.1+100*0.05+100*0.01);
    	List<Float> interestPerWalletLst = new ArrayList<Float>();
    	interestPerWalletLst.add(new Float(100.*0.1+100*0.01));
    	interestPerWalletLst.add(new Float(100.*0.05));
    	Response response = new Response();
    	response.setTotalInterest(totalInterest);
    	response.setInterestPerWallet(interestPerWalletLst);
    	List<Response> responseLst = new ArrayList<Response>();
    	responseLst.add(response);
    	
        when(creditCardInterestCal.calculate(any(Request.class))).thenReturn(responseLst);
        assertNotNull(responseLst);
    }
    
// 2 people have 1 wallet each,  person 1 has 1 wallet , with 2 cards MC and visa person 2 has 1 wallet – 1 visa and 1 MC -  each card has $100 balance - calculate the total interest(simple interest) for each person and interest per wallet
    @Test
    public void test3() {
    	
    	Float totalInterest1 = new Float(100*0.05+100*0.1);
    	List<Float> interestPerWalletLst1 = new ArrayList<Float>();
    	interestPerWalletLst1.add(new Float(100.*0.1+100*0.05));
    	Response response1 = new Response();
    	response1.setTotalInterest(totalInterest1);
    	response1.setInterestPerWallet(interestPerWalletLst1);
    	
    	Float totalInterest2 = new Float(100*0.05+100*0.1);
    	List<Float> interestPerWalletLst2 = new ArrayList<Float>();
    	interestPerWalletLst2.add(new Float(100.*0.1+100*0.05));
    	Response response2 = new Response();
    	response2.setTotalInterest(totalInterest2);
    	response2.setInterestPerWallet(interestPerWalletLst2);

    	List<Response> responseLst = new ArrayList<Response>();
    	responseLst.add(response1);
    	responseLst.add(response2);

        when(creditCardInterestCal.calculate(any(Request.class))).thenReturn(responseLst);
        assertNotNull(responseLst);
    }
    
 //following need to be moved to src folder package when implementing the code. Add here for junit to run
    
    public class CreditCardInterestCal {
    	public List<Response> calculate(Request request)	{
    		return new ArrayList<>();
    	}
    }
    
    public class Request{
    	//not implemented
    }
    public class Response{
    	
    	Float totalInterest;
		List<Float> interestPercard;
    	List<Float> interestPerWallet;
    	
    	public Float getTotalInterest() {
			return totalInterest;
		}
		public void setTotalInterest(Float totalInterest) {
			this.totalInterest = totalInterest;
		}
		public List<Float> getInterestPercard() {
			return interestPercard;
		}
		public void setInterestPercard(List<Float> interestPercard) {
			this.interestPercard = interestPercard;
		}
		public List<Float> getInterestPerWallet() {
			return interestPerWallet;
		}
		public void setInterestPerWallet(List<Float> interestPerWallet) {
			this.interestPerWallet = interestPerWallet;
		}

    }

}
