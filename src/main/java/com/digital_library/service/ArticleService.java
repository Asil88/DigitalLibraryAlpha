package digitLibrary.service;


import digitLibrary.domain.Article;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class ArticleService {

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
                article.setAuthorName(resultSet.getString("author_name"));
                articles.add(article);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }

   /* public int createArticle(String title, String authorName) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO article (article_id,title,author_name) VALUES (DEFAULT, ?,?)");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, authorName);
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }*/

    public int createArticle(Article article) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/digit_library_db", "postgres", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO article (article_id,title,author_name) VALUES (DEFAULT, ?,?)");
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2, article.getAuthorName());
            result = preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


}
