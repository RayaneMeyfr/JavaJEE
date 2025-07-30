<%--
  Created by IntelliJ IDEA.
  User: Rayan
  Date: 30/07/2025
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="chien" type="org.example.exo4.model.Chien" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous" defer></script>
</head>
<body>
<main class="container">
    <h1>DETAILS</h1>

    <hr>

    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${chien.nom}</td>
                <td>${chien.race}</td>
                <td>${chien.dateNaissance}</td>
            </tr>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/chien">Retour a la liste</a><br>
    <a href="${pageContext.request.contextPath}/">Retour a la page d'accueil</a>
</main>
</body>
</html>
