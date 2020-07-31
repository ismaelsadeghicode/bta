package com.mapsa.bta.controller;

import com.mapsa.bta.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "register",urlPatterns = "/registering")
public class register extends HttpServlet {
    public static HashSet<Person> people = new HashSet<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email").toLowerCase();
        String password=request.getParameter("password");
        if(!Person.checkEmail(email) || password.trim().isEmpty() ||name.trim().isEmpty()) {
            response.sendRedirect("register.html");
        }else if(Person.checkEmail(email)){
            people.add(new Person(name,password,email));
            for(Person p:people){
                System.out.println(p);
            }response.sendRedirect("login.html");
        }else{
            response.sendRedirect("register.html");
        }
    }


}
