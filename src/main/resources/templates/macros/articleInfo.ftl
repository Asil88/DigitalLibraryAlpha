<#macro articleInfo article>
    <font color="#ff1493">Article</font>
    <br><br>
    Id: ${article.id}
    <br><br>
    Title: ${article.title}
    <br><br>
    Date of Creation ${(article.dateOfCreation)!"default data"}
    <br><br>
    AuthorId: ${article.authorId}
    <br><br>
    Text: ${article.text}
    <br><br>
    Download: ${article.download}
    <br><br>
</#macro>