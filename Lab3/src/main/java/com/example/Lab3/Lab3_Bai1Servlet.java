package com.example.Lab3;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
@MultipartConfig()
@WebServlet(name = "Lab3_Bai1Servlet", value = "/upload-file")
public class Lab3_Bai1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/upload_file_form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File(request.getServletContext().getRealPath("/files"));
        if (!file.exists()){
            file.mkdirs();
        }

        Part photo = request.getPart("photo");
        File photoFile = new File(file, photo.getSubmittedFileName());
        photo.write(photoFile.getAbsolutePath());

        Part document = request.getPart("document");
        File docFile = new File(file, document.getSubmittedFileName());
        document.write(docFile.getAbsolutePath());

        request.setAttribute("img", photoFile);
        request.setAttribute("doc", docFile);

        request.getRequestDispatcher("/views/upload_file_result.jsp").forward(request, response);
    }
}
