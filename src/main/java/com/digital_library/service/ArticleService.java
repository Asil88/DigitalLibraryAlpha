package com.digital_library.service;


import com.digital_library.annotations.CheckTimeAnnotation;
import com.digital_library.domain.Article;
import com.digital_library.exception.ArticleNotFoundException;
import com.digital_library.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;



@Service
public class ArticleService {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Article getArticleById(int id) {
        Article article = new Article();
        try {
            article = jdbcTemplate.queryForObject("SELECT * FROM articles WHERE article_id=?", new ArticleMapper(), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            return article;
        }
        return article;
    }

    public ArrayList<Article> getAllArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        return (ArrayList<Article>) jdbcTemplate.query("SELECT * FROM articles", new ArticleMapper());
    }

    public int createArticle(Article article) {
        return jdbcTemplate.update("INSERT INTO articles (article_id,title,author_id,article_text,download,date_of_creation) VALUES (DEFAULT, ?, ?, ?, ?, ?)",
                new Object[]{article.getTitle(), article.getAuthorId(), article.getText(), article.getDownload(), article.getDateOfCreation()});
    }

    public int updateArticleById(Article article) {
        return jdbcTemplate.update("UPDATE articles SET title=?,author_id=?,article_text=?,download=?,date_of_creation=? WHERE article_id=?",
                new Object[]{article.getTitle(),article.getAuthorId(),article.getText(),article.getDownload(),article.getDateOfCreation(),article.getId()});
    }


    public int deleteArticleById(int id) {
        return jdbcTemplate.update("DELETE FROM articles WHERE article_id=?",new Object[]{id});
    }
}





/*

@Service
public class ArticleService {
    @CheckTimeAnnotation
    public Article getArticleById(int id) throws ArticleNotFoundException {
        Article article = new Article();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM article WHERE article_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            article.setId(resultSet.getInt("article_id"));
            article.setTitle(resultSet.getString("title"));
            article.setAuthorId(resultSet.getInt("author_id"));
            article.setText(resultSet.getString("article_text"));
            article.setDownload(resultSet.getString("download"));
            article.setDateOfCreation(resultSet.getDate("date_of_creation"));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        if (article.getId() == 0) {
            throw new ArticleNotFoundException(id);
        }
        return article;
    }

    public ArrayList<Article> getAllArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM article");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("article_id"));
                article.setTitle(resultSet.getString("title"));
                article.setAuthorId(resultSet.getInt("author_id"));
                article.setText(resultSet.getString("article_text"));
                article.setDownload(resultSet.getString("download"));
                article.setDateOfCreation(resultSet.getDate("date_of_creation"));

                articles.add(article);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }


    public int createArticle(Article article) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO article (article_id,title,author_id,article_text,download,date_of_creation) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setLong(2, article.getAuthorId());
            preparedStatement.setString(3,article.getText());
            preparedStatement.setString(4,article.getDownload());
            preparedStatement.setDate(5, article.getDateOfCreation());

            result = preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }

    public int updateArticleById(long id, String title, Date dateOfCreation, long authorId, String text,String download) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE article SET title=?,author_id=?,article_text=?,download=?,date_of_creation=? WHERE article_id=?");
            preparedStatement.setString(1, title);
            preparedStatement.setDate(2, dateOfCreation);
            preparedStatement.setLong(3, authorId);
            preparedStatement.setString(4, text);
            preparedStatement.setString(5, download);
            preparedStatement.setLong(6, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }

    public int deleteArticleById(int id) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM article WHERE article_id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }
}
*/
