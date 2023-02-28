<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 03.02.2023
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>ALL ARTICLE VIEW</title>
</head>
<body>


<c:forEach items="${articles}" var="article">
    <font color="#ff1493" Article:/>
    <br><br>
    Id: ${article.id}
    <br><br>
    Title: ${article.title}
    <br><br>
    Date of Creation ${article.dateOfCreation}
    <br><br>
    AuthorId: ${article.authorId}
    <br><br>
    Text: ${article.text}
    <br><br>
    Download: ${article.download}
    <br><br> <br><br>
</c:forEach>

</body>
</html>
