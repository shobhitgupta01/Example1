package com.shobhit;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	
	private int id;
	private String name;
	private float balance;
	
	//Constructors
	
	/*
	 * Default Constructor
	 */
	Account(){}
	
	/*
	 * Parameterized Constructor
	 */
	Account(String name,float balance)
	{
		this.name=name;
		this.balance=balance;
	}
	
	/*
	 * Getter Methods
	 */
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public float getBalance()
	{
		return balance;
	}
	
	/*
	 * Setter Methods
	 */
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setBalance(float balance)
	{
		this.balance=balance;
	}
	
	

}
