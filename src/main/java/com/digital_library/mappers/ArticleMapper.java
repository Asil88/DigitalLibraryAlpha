package com.digital_library.mappers;

import com.digital_library.domain.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Article article = new Article();
        article.setId(resultSet.getInt("article_id"));
        article.setTitle(resultSet.getString("title"));
        article.setAuthorId(resultSet.getInt("author_id"));
        article.setText(resultSet.getString("article_text"));
        article.setDownload(resultSet.getString("download"));
        article.setDateOfCreation(resultSet.getDate("date_of_creation"));
        return article;
    }
}
