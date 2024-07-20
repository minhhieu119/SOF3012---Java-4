package com.example.Lab3;

import com.example.Lab3.entity.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Lab3_Bai2Servlet", value = "/staff")
public class Lab3_Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/beans_form.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyyy");
            ConvertUtils.register(dtc, Date.class);

            Staff staff = new Staff();
            BeanUtils.populate(staff, request.getParameterMap());

            System.out.println(staff.getBirthday());

            if (staff.isGender()){
                request.setAttribute("gender", "Nam");
            } else {
                request.setAttribute("gender", "Nữ");
            }

            if (staff.getCountry().equals("VI")){
                request.setAttribute("country", "Việt Nam");
            } else if (staff.getCountry().equals("US")){
                request.setAttribute("country", "Mỹ");
            } else if (staff.getCountry().equals("JP")){
                request.setAttribute("country", "Nhật Bản");
            }

            if (staff.isMaried()){
                request.setAttribute("maried", "Đã kết hôn");
            } else {
                request.setAttribute("maried", "Chưa kết hôn");
            }

            String hobbies = "";
            for (String h:
                    staff.getHobies()) {
                if (h.equals("R")){
                    hobbies += "Đọc sách" + " ";
                } else if (h.equals("T")){
                    hobbies += "Du lịch" + " ";
                } else if (h.equals("M")){
                    hobbies += "Nghe nhạc" + " ";
                } else if (h.equals("O")){
                    hobbies += "Khác" + " ";
                }
            }
            request.setAttribute("hobbies", hobbies);

            request.setAttribute("bean", staff);
        } catch (Exception e){
            e.printStackTrace();
        }

        request.getRequestDispatcher("/views/beans_result.jsp").forward(request, response);
    }
}
