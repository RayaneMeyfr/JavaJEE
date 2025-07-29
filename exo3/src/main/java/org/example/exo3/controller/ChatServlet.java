package org.example.exo3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo3.model.Chat;
import org.example.exo3.model.Race;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ChatServlet", value = "/chat")
public class ChatServlet extends HttpServlet {
    private List<Chat> chats;
    @Override
    public void init() throws ServletException {
        chats = new ArrayList<>();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("races", Arrays.asList(Race.values()));
        request.setAttribute("chats", chats);
        getServletContext().getRequestDispatcher("/chat/inscriptionList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String raceParam = req.getParameter("race");
        String bestMeal = req.getParameter("bestMeal");
        String birthday = req.getParameter("birthday");

        Race race = Race.valueOf(raceParam.toUpperCase());
        chats.add(new Chat(name,race,bestMeal,birthday));

        req.setAttribute("races", Arrays.asList(Race.values()));
        req.setAttribute("chats", chats);

        getServletContext().getRequestDispatcher("/chat/inscriptionList.jsp").forward(req, resp);
    }
}
