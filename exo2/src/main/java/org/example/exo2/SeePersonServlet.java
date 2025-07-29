package org.example.exo2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo2.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "seepersonServlet", value = "/seeperson")
public class SeePersonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 18));
        persons.add(new Person("Jane", "Doe", 19));
        persons.add(new Person("Jack", "Doe", 20));
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/view/printPerson.jsp").forward(request,response);
    }
}
