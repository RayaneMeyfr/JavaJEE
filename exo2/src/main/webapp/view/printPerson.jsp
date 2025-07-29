<%--
  Created by IntelliJ IDEA.
  User: Rayan
  Date: 29/07/2025
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="persons" type="java.util.ArrayList<org.example.exo2.model.Person>" scope="request" />
<html>
<head>
    <title>Listes des personnes</title>
    <jsp:include page="../WEB-INF/link.jsp" />
</head>
<body>
    <jsp:include page="../WEB-INF/nav-bar.jsp" />
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">âge</th>ge
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <c:forEach var="p" items="${persons}" >
            <tr>
                <td> ${p.name}</td>
                <td> ${p.prenom}</td>
                <td> ${p.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
