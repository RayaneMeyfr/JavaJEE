package org.example.exo4.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo4.model.Chien;
import org.example.exo4.service.IServiceChien;
import org.example.exo4.service.ServiceChien;
import org.example.exo4.util.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name = "chienServlet", value = {"/chien","/chien/add","/chien/details"})
public class ChienServlet extends HttpServlet {
    private IServiceChien serviceChien;

    public void init() throws ServletException {
        serviceChien = new ServiceChien(HibernateSession.getSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case "/chien/add":
                this.add(request, response);
                break;
            case "/chien/details":
                this.details(request, response);
                break;
            default:
                this.list(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");

        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        Chien chien = new Chien(name, breed, dateOfBirth);
        serviceChien.addChien(chien);
        resp.sendRedirect(getServletContext().getContextPath()+"/chien");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/chien/add.jsp").forward(req, resp);
    }

    public void details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                Chien chien = serviceChien.getChienById(id);
                if (chien != null) {
                    request.setAttribute("chien", chien);
                    request.getRequestDispatcher("/WEB-INF/chien/details.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/chien");
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("chienList", serviceChien.getAll());
        request.getRequestDispatcher("/WEB-INF/chien/list.jsp").forward(request, response);
    }

}
