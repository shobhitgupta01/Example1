package com.shobhit;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/app")

public class AccountHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
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

}
