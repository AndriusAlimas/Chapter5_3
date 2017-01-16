package com.example.listener;
import com.example.Dog;
import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent ContextEvent) {
		// Ask event for ServletContext:
		 ServletContext sc = ContextEvent.getServletContext();
		// first thing first lets invoke to write log file to be notice for troubleshooting:
	     sc.log("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
	     		+ "$$$ServletContext event contextDestroyed has been invoked "
	     		+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	     // as well for simply test using System.out.println:
	     System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
	     		+ "$$$ServletContext event contextDestroyed has been invoked "
	     		+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	@Override
	public void contextInitialized(ServletContextEvent ContextEvent) {
	// Ask event for ServletContext:
	ServletContext sc = ContextEvent.getServletContext();
	// first thing first lets invoke to write log file to be notice for troubleshooting:
    sc.log("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
    		+ "$$$$$$$$ServletContext event contextInitialized has been invoked "
    		+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    // as well for simply test using System.out.println:
    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
    		+ "$$$$$$$$ServletContext event contextInitialized has been invoked "
    		+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	// Use the context to get the init parameter:
	String dogBreed = sc.getInitParameter("breed");
	String dogSize = sc.getInitParameter("size");
	// make a new Dog object using information :
	Dog d = new Dog(dogBreed);
	// another dog object using other dog constructor which include the size
	Dog d2 = new Dog(d.getBreed(),dogSize);
	// set context scope attribute, save as objects dogs , later all application can use it:
	 sc.setAttribute("dog", d);
     sc.setAttribute("dog_size", d2);
		
	}

}
