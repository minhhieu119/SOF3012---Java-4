package com.example.Lab2_1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@WebServlet(name = "Lab2_bai4Servlet", value = "/Lab2_bai4Servlet")
public class Lab2_bai4Servlet extends HttpServlet {
    int count;
    Path path = Paths.get("e:/count.txt");
    @Override
    public void init() throws ServletException {
        try {
            count = Integer.parseInt(Files.readAllLines(path).get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count++;
        req.setAttribute("count", count);
        req.getRequestDispatcher("/Bai4/hit_counter.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        try {
            Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
