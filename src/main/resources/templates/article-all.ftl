
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
