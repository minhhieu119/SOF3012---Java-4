package com.example.Lab2;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Lab2_Bai1Servlet", value = {"/Lab2_Bai1Servlet", "/dien_tich", "chu_vi"})
public class Lab2_Bai1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Bai1/tamGiac.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        double a = Double.parseDouble(request.getParameter("a"));
//        double b = Double.parseDouble(request.getParameter("b"));
//        double c = Double.parseDouble(request.getParameter("c"));
//
//        if ((a + b > c) && (a + c > b) && (b + c > a)){
//            double chuVi = (a + b + c);
//            String uri = request.getRequestURI();
//            if (uri.contains("dien-tich")){
//                double dienTich = Math.sqrt(chuVi * (a + b -c) * (a + c - b) * (b + c - a)) / 4;
//                request.setAttribute("message", "Diện tích của tam giác là: " + dienTich);
//            } else {
//                request.setAttribute("message", "Chu vi của tam giác là: " + chuVi);
//            }
//        } else {
//            request.setAttribute("message" , "Không thỏa mãn các cạnh của 1 tam giác");
//        }
//        request.getRequestDispatcher("/Bai1/tamGiac.jsp").forward(request, response);
    }
}
