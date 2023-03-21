package com.digital_library.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;

@Data
@Component
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
