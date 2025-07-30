<%--
  Created by IntelliJ IDEA.
  User: Rayan
  Date: 30/07/2025
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="chienList" type="java.util.ArrayList<org.example.exo4.model.Chien>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous" defer></script>
</head>
<body>
<main class="container">
    <h1>Liste de Chiens</h1>
    <hr>

    <c:if test="${chienList.size() > 0}">
        <table class="table table-dark text-center align-middle">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Race</th>
                <th>Date de naissance</th>
                <th>Details</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="c" items="${chienList}" >
                <tr>
                    <td>${c.nom}</td>
                    <td>${c.race}</td>
                    <td>${c.dateNaissance}</td>
                    <td><a href="${pageContext.request.contextPath}/chien/details?id=${c.id}">voir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${chienList.size() == 0}">
        <p>Aucun Chien a presenter</p>
    </c:if>

    <a href="${pageContext.request.contextPath}/chien/add">Ajouter un Chien</a><br>
    <a href="${pageContext.request.contextPath}/">Retour a la page d'accueil</a>

</main>


</body>
</html>
