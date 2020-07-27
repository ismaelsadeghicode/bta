package com.mapsa.zone.projectname;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet" ,urlPatterns = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        ConstVariable.name=userName;
        ConstVariable.password=password;
        //request.getRequestDispatcher("/HelloServlet/").forward(request,response);
        response.sendRedirect("registerSucces.html");
        System.out.println(userName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
