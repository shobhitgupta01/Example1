package com.shobhit;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Console;
import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/app")

public class AccountHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/accounts")
	public List<Account> getAccounts()
	{
		Configuration cfg = new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		List<Account> list = session.createQuery("from Account").list();
		
		session.getTransaction().commit();
		session.close();
		
		
		return list;
		
		
	}
	
	/*
	 * Method for handling post requests to add new account
	 */
	@POST
	//@Produces(MediaType.TEXT_HTML)
	@Path("/create")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newAccount(@FormParam("name") String name,@FormParam("balance") float balance,@Context HttpServletResponse servletResponse)throws IOException
	{
		
		
		System.out.println("\n\nReceived "+name+" "+balance+" \n\n");
		Configuration cfg = new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Account acc = new Account();
		acc.setName(name);
		acc.setBalance(balance);
		session.persist(acc);
		transaction.commit();
		session.close();
		servletResponse.sendRedirect("http://localhost:8080/Example1/index.html");
	}

}
