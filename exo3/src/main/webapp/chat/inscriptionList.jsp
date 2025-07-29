<%@ page import="org.example.exo3.model.Race" %><%--
  Created by IntelliJ IDEA.
  User: Rayan
  Date: 29/07/2025
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous" defer></script>
</head>
<body>

<form action="chat" method="post" class="container mt-5">
    <div class="mb-3">
        <label for="name" class="form-label">Nom du chat :</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>

    <div class="mb-3">
        <label for="race" class="form-label">Race :</label>
        <select class="form-select" id="race" name="race" required>
            <c:forEach var="r" items="${races}">
                <option value="${r}">${r}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label for="bestMeal" class="form-label">Plat préféré :</label>
        <input type="text" class="form-control" id="bestMeal" name="bestMeal" required>
    </div>

    <div class="mb-3">
        <label for="birthday" class="form-label">Date de naissance :</label>
        <input type="date" class="form-control" id="birthday" name="birthday" required>
    </div>

    <button type="submit" class="btn btn-primary">Envoyer</button>
</form>

<c:if test="${chats.size() > 0}">
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Repas Favoris</th>
            <th>date naissance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${chats}" >
            <tr>
                <td>${c.name}</td>
                <td>${c.race}</td>
                <td>${c.bestMeal}</td>
                <td>${c.birthday}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${chats.size() == 0}">
    <p>Aucune Chat a presenter</p>
</c:if>
</body>
</html>
