<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 03.02.2023
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="article" type="com"--%>
<form:form action="/postFormArticle" modelAttribute="article">

    title<form:input path="title"/>
    <br><br>
    author<form:input path="authorName"/>
    <br><br>
</form:form>

</body>
</html>
