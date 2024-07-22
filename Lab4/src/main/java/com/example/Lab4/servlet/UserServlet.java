package com.example.Lab4.servlet;

import com.example.Lab4.entity.User;
import com.example.Lab4.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@WebServlet({
        "/user/hien-thi",
        "/user/view-add",
        "/user/add",
        "/user/view-update",
        "/user/update",
        "/user/delete"
})
public class UserServlet extends HttpServlet {
    UserService us = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiDanhSach(req, resp);
        } else if (uri.contains("view-add")) {
            this.viewAdd(req, resp);
        } else if (uri.contains("delete")) {
            this.delete(req, resp);
        } else {
            this.viewUpdate(req, resp);
        }
    }

    @SneakyThrows
    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int index = Integer.parseInt(req.getParameter("viTri"));
        us.deleteUser(index);
        resp.sendRedirect("/user/hien-thi");
    }


    @SneakyThrows
    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) {
        int index = Integer.parseInt(req.getParameter("viTri"));
        User u = us.getUser(index);
        req.setAttribute("u", u);
        req.getRequestDispatcher("/user/update-user.jsp").forward(req, resp);
    }


    @SneakyThrows
    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/user/add-user.jsp");
    }

    @SneakyThrows
    private void hienThiDanhSach(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list", us.fillAll());
        req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("add")) {
            this.add(req, resp);
        } else {
            this.update(req, resp);
        }
    }

    @SneakyThrows
    private void add(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        Boolean admin = req.getParameter("admin") != null;
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        if (id.trim().isEmpty() || password.trim().isEmpty() || email.trim().isEmpty() || fullname.trim().isEmpty()) {
            req.setAttribute("message", "Bạn không được để trống các trường");
            req.getRequestDispatcher("/user/add-user.jsp").forward(req, resp);
        }
        String regex = "^[a-zA-Z]{1,}[0-9]{1,}$";

        boolean checkPass = Pattern.matches(regex, password);
        System.out.println(checkPass);
        if (password.length() <= 6 || !checkPass) {
            req.setAttribute("message", "Sai địng dạng password");
            req.getRequestDispatcher("/user/add-user.jsp").forward(req, resp);
        }
        for (int i = 0; i < us.fillAll().size(); i++) {
            if (us.fillAll().get(i).getId().equalsIgnoreCase(id)) {
                req.setAttribute("message", "Đã tồn tại mã này");
                req.getRequestDispatcher("/user/add-user.jsp").forward(req, resp);
            }
            if (us.fillAll().get(i).getEmail().equalsIgnoreCase(email)) {
                req.setAttribute("message", "Đã tồn tại email này");
                req.getRequestDispatcher("/user/add-user.jsp").forward(req, resp);
            }
        }
        User user = new User(id, password, email, fullname, admin);
        us.addUser(user);
        resp.sendRedirect("/user/hien-thi");
    }

    @SneakyThrows
    private void update(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        User u = new User();
        int index = 0;
        boolean isValidate = false;
        List<User> list = us.fillAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                u = list.get(i);
                break;
            }
            index++;
        }

        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        System.out.println(req.getParameter("admin"));
        Boolean admin = req.getParameter("admin") != null ? true : false;
        if (email.trim().isEmpty() || fullname.trim().isEmpty()) {
            req.setAttribute("message", "Bạn không được để trống các trường");
            req.setAttribute("u", u);
            req.getRequestDispatcher("/user/update-user.jsp").forward(req, resp);
            isValidate = true;
        }
        if (isValidate == false) {
            u.setEmail(email);
            u.setFullname(fullname);
            u.setAdmin(admin);
            us.updateUser(index, u);
            resp.sendRedirect("/user/hien-thi");
        }

    }
}
