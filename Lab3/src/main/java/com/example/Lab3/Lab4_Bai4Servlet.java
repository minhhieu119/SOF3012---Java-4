package com.example.Lab3;

import com.example.Lab3.service.CookieUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Lab4_Bai4Servlet", value = "/cookie")
public class Lab4_Bai4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = CookieUtils.get("username", request);
        String password = CookieUtils.get("password", request);

        request.setAttribute("username", username);
        request.setAttribute("password", password);

        request.getRequestDispatcher("/views/login_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");


        System.out.println(username);
        if (!username.equalsIgnoreCase("admin")){
            request.setAttribute("message", "Sai username");
        } else if (password.length() < 8){
            request.setAttribute("message", "Mật khẩu phải từ 8 kí tự");
        } else {
            request.setAttribute("message", "Đăng nhập thành công");
            int hours = (remember == null) ? 0 : 30 * 24;
            CookieUtils.add("username", username, hours, response);
            CookieUtils.add("password", password, hours, response);
        }
        request.getRequestDispatcher("/views/login_form.jsp").forward(request, response);
    }
}
