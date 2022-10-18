package controller;

import database.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet(name = "StudentCreateController", value = "/create-student")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/create-student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//1)Получить данные с формы
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        String dateFronUser = request.getParameter("date");

        if (surname.isEmpty() || name.isEmpty() || group.isEmpty() || dateFronUser.isEmpty()) {
            request.setAttribute("error", "1");
            request.setAttribute("surname", surname);
            request.setAttribute("name", name);
            request.setAttribute("group", group);
            request.setAttribute("dateFronUser", dateFronUser);
            request.getRequestDispatcher("JSP/create-student.jsp").forward(request, response);
            return;
        }

        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(dateFronUser);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateToBD = formatter.format(date);


        //2) БД\
        DBManager manager = new DBManager();
        manager.createStudent(surname, name, group, dateToBD);
        //3) вернуться на другйю страницу
        response.sendRedirect("/student");


    }
}
