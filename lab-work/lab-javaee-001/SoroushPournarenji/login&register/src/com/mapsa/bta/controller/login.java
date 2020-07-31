package com.mapsa.bta.controller;

import com.mapsa.bta.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/home")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").toLowerCase();
        String password = request.getParameter("password");
        boolean flag = false;
        for (Person p : register.people) {
            if (username.equals(p.getEmail()) && p.checkPassword(password)) {
                flag = true;
                break;
            }
        }if(!Person.checkEmail(username) || password.trim().isEmpty()){
            response.sendRedirect("login.html");
        }else if (flag) {
            try (PrintWriter pw = response.getWriter();) {
                pw.write("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Home</title>\n" +
                        "</head>\n" +
                        "<body style=\"background-color:#383D41\">\n" +
                        "<b style=\"font-size:40px;color: #0b2e13\">you are now logged in</b> <br/> <br/><p style=\"font-size:30px\">"
                        + username +
                        " (User)</p>\n" +
                        "</body>\n" +
                        "</html>");
            }

        } else {
            response.sendRedirect("login.html");
        }
    }

}
