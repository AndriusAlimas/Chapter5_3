package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.Dog;

import java.io.*;
import java.util.Enumeration;

public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Test ServletContextListener </title></head>");
        out.println("<body>test context attributes set by listener<br>");
        // Now get the Dog from ServletContext. If the listener method worked the Dog will be there BEFORE
        // this service method is called for the first time:
        Dog dog = (Dog)getServletContext().getAttribute("dog");
        out.println("<hr><b>Dog's breed is: " + dog.getBreed() + "</b><br>");
        out.println("<hr><b>Now Testing getAttributeNames() all Enumeration list:</b><br>");
        
        Enumeration<String> enumeration = this.getServletContext().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            out.println("<br><i>" + enumeration.nextElement() + "</i>");
        }
        // int getMajorVersion() returns the major version of the Servlet API that this servlet 
        // container supports. All implementations that comply with Version 3.0 must have this method return the integer 3.
        out.println("<hr>Server Version: <i><b>" + this.getServletContext().getMajorVersion() + "</i></b>");
        
        // java.lang.String getServerInfo() returns the name and version of the servlet container on
        // which the servlet is running. The form of the returned string is servername/versionnumber.
        // For example, the JavaServer Web Development Kit may return the string JavaServer Web Dev Kit/1.0.
        // The servlet container may return other optional information after the primary string in 
        // parentheses, for example, JavaServer Web Dev Kit/1.0 (JDK 1.1.6; Windows NT 4.0 x86).
        out.println("<hr>Server Info: <i><b>" + this.getServletContext().getServerInfo() + "</i></b>");
        
        out.println("</body></html>");
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Test delete_attribute </title></head>");
        // get parameter from form and store to simple String value:
        String delete_att = request.getParameter("delete_attribute");
        // you can add, remove or replace attribute same use:
        getServletContext().removeAttribute(delete_att);
        
        // get context scope all attribute names:
        Enumeration<String> enumeration = this.getServletContext().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            out.println("<br><i>" + enumeration.nextElement() + "</i>");
        }
        
        out.println("<body><hr>We want to delete this attribute :<b>" + delete_att + "</b><br>");
        out.println("</body></html>");
	}
}
