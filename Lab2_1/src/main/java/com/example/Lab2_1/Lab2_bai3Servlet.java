package com.example.Lab2_1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

@WebServlet(name = "Lab2_bai3Servlet", value = "/dang_ki_bai3")
public class Lab2_bai3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Form_bai3/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String account = request.getParameter("account");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        boolean maried = (request.getParameter("maried") != null);
        String country = request.getParameter("country");
        String [] hobies = request.getParameterValues("hobies");

        System.out.println(">>account: "+ account);
        System.out.println(">>gender: "+ gender);
        System.out.println(">>maried: "+ maried);
        System.out.println(">>country: "+ country);
        System.out.println(">>hobies: "+ Arrays.toString(hobies));

        request.getRequestDispatcher("/Form_bai3/form_result.jsp").forward(request, response);
    }
}
