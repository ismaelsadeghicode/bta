package com.mapsa.zone.projectname;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        if(name.equals(ConstVariable.name)&&password.equals(ConstVariable.password))
        {
            System.out.println("login success."+request.getContextPath());
            response.sendRedirect("succes.html");
        }else{
            System.out.println("invalid password or username."+request.getContextPath());
            response.sendRedirect("error.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
