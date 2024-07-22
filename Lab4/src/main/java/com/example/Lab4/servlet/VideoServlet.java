package com.example.Lab4.servlet;

import com.example.Lab4.entity.Video;
import com.example.Lab4.service.VideoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(name = "VideoServlet", value = {
        "/video/hien-thi",
        "/video/view-add",
        "/video/add",
        "/video/view-update",
        "/video/update",
        "/video/delete"
})
public class VideoServlet extends HttpServlet {
    VideoService vs = new VideoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")){
            this.hienThi(request, response);
        } else if (uri.contains("view-add")){
            this.viewAdd(request, response);
        } else if (uri.contains("view-update")){
            this.viewUpdate(request, response);
        } else {
            this.delete (request, response);
        }
    }

    @SneakyThrows
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int viTri = Integer.parseInt(request.getParameter("viTri"));
        vs.delete(viTri);
        response.sendRedirect("/video/hien-thi");
    }

    @SneakyThrows
    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
        int viTri = Integer.parseInt(request.getParameter("viTri"));
        Video v = vs.getVideoByIndex(viTri);
        request.setAttribute("video", v);
        request.getRequestDispatcher("/video/update-video.jsp").forward(request, response);
    }

    @SneakyThrows
    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
        response.sendRedirect("/video/add-video.jsp");
    }

    @SneakyThrows
    private void hienThi(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("list", vs.getList());
        request.getRequestDispatcher("/video/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    @SneakyThrows
    private void update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int index = 0;
        Video v = new Video();
        for (int i = 0; i < vs.getList().size(); i++){
            if (vs.getList().get(i).getId().equalsIgnoreCase(id)){
                v = vs.getList().get(i);
                break;
            }
            index++;
        }

        String title = request.getParameter("title");
        String decription = request.getParameter("decription");
        boolean active = request.getParameter("active") !=  null ? true : false;
        String poster = request.getParameter("poster");
        boolean isValidate = false;

        if (title.trim().isEmpty()){
            isValidate = true;
            request.setAttribute("titleMess", "Bạn chưa nhập Title");
        }

        if (poster.trim().isEmpty()){
            isValidate = true;
            request.setAttribute("posterMess", "Bạn chưa nhập Poster");
        }

        if (!isValidate){
            v.setTitle(title);
            v.setDescription(decription);
            v.setActive(active);
            v.setPoster(poster);
            vs.update(index, v);
            response.sendRedirect("/video/hien-thi");
        } else {
            request.setAttribute("video", v);
            request.getRequestDispatcher("/video/update-video.jsp").forward(request, response);
        }

    }

    @SneakyThrows
    private void add(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String decription = request.getParameter("decription");
        boolean active = request.getParameter("active") !=  null ? true : false;
        String poster = request.getParameter("poster");
        boolean isValidate = false;

        if (id.trim().isEmpty()){
            isValidate = true;
            request.setAttribute("idMess", "Bạn chưa nhập ID");
        }

        if (checkID(id)){
            isValidate = true;
            request.setAttribute("idMess", "Đã tồn tại ID, mời nhập lại");
        }

        if (title.trim().isEmpty()){
            isValidate = true;
            request.setAttribute("titleMess", "Bạn chưa nhập Title");
        }

        if (poster.trim().isEmpty()){
            isValidate = true;
            request.setAttribute("posterMess", "Bạn chưa nhập Poster");

        }

        if (!isValidate){
            Video v = new Video(id, title, decription, active, poster);
            vs.add(v);
            response.sendRedirect("/video/hien-thi");
        } else {
            request.getRequestDispatcher("/video/add-video.jsp").forward(request, response);
        }
    }

    private boolean checkID (String id){
        for (Video v : vs.getList()) {
            if (v.getId().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }


}
