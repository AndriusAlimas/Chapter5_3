package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.example.Dog;

import java.io.*;

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
        out.println("</body></html>");
	}
}
