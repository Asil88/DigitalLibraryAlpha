package com.digital_library.domain;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;


@Component
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
    @SequenceGenerator(name = "article_seq", sequenceName = "article_article_id_seq")
    private long id;

    @Size(min = 5, max = 16)
    @Column(name = "title")
    private String title;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;
    //@IsAdult
    @Column(name = "author_id")
    private long authorId;

    @Pattern(regexp = "[A-Z,a-z]*")
    private String text;

    private String download;

    public Article() {
    }

    public Article(String title, Date dateOfCreation, long authorId, String text, String download) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.authorId = authorId;
        this.text = text;
        this.download = download;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                ", authorId=" + authorId +
                ", text='" + text + '\'' +
                ", download='" + download + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id && authorId == article.authorId && Objects.equals(title, article.title) && Objects.equals(dateOfCreation, article.dateOfCreation) && Objects.equals(text, article.text) && Objects.equals(download, article.download);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, dateOfCreation, authorId, text, download);
    }
}
