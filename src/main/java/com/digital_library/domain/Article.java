package digitLibrary.domain;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Component
public class Article {

    private long id;
    @Size(min = 5, max = 16)
    private String title;
    // private LocalDate dateOfCreation;

    private String authorName;

    public Article() {
    }

    public Article(long id, String title, String authorName) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
