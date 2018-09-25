package com.siri.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSession {
	
	public static Session sessionObj;
	public static SessionFactory sessionFactoryObj = null;
	
	private HibernateSession() {
		
	}
	
	public  static  SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");
		
		

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new ServiceRegistryBuilder().applySettings(configObj.getProperties()).buildServiceRegistry(); 
		if(sessionFactoryObj == null) {
			synchronized(new Object()) {
				sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
			}
			
			return sessionFactoryObj;
		} else {
			return sessionFactoryObj;
		}
		// Creating Hibernate SessionFactory Instance
		
		
	}

}


	



