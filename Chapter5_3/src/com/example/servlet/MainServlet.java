package com.example.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Test ServletContextListener </title></head>");
        out.println("<body>test context attributes set by listener<br>");
        
        out.println("</body></html>");
	}
}
