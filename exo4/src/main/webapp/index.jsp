<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/chien">voir la liste</a><br>
<a href="${pageContext.request.contextPath}/chien/add">Ajouter un Chien</a>

</body>
</html>