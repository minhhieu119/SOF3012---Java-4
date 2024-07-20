package com.example.Lab2_1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Lab2_bai2Servlet", value = "/dang_ki")
public class Lab2_bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Form_bai2/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String account = request.getParameter("account");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        boolean maried = (request.getParameter("maried") != null);
        String country = request.getParameter("country");

        System.out.println(">>account: "+ account);
        System.out.println(">>gender: "+ gender);
        System.out.println(">>maried: "+ maried);
        System.out.println(">>country: "+ country);

        request.getRequestDispatcher("/Form_bai2/form_result.jsp").forward(request, response);
    }
}
