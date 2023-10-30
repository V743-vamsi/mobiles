package com.mobiles.demo.controller;

import com.example.demo.paymentException.paymentException;

public class Orderconformation {
	 static  String payment(int amt ,int b,int actualamt) throws paymentException
	{
		
	String str;
	if(amt==1)
		
	{
		System.out.println("You have selected cash on delivery option,it will based on payment="+amt);
		System.out.println("Cash paid Successfully it will reach you 7days....!");
		System.out.println("Thank you...!");
		return "Cash on Delivery confirmed";
		
	}
	else if(amt==2)
		
	{ 
		if(amt==actualamt) 
		{
		System.out.println("You have selected Online Payment");
		System.out.println("Online Payment done Successfully :"+amt);
		System.out.println("Your Order will be confirmed track your order");
		System.out.println("Thank you...!");	
		return " Delivery confirmed";
	}else
	{
		throw new paymentException("insufficent amt");
	}
	}
	else 
	{
		System.out.println("Entered invalid option Please Try again...");
		return "try again";
	}
	}

	}

