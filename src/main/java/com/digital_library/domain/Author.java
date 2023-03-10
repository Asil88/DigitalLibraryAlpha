package com.digital_library.domain;



import com.digital_library.util.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
@Data
@ToString(exclude = {"booklist"})
@EqualsAndHashCode(exclude = {"booklist"})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "biography")
    private String biography;
    @Column(name = "description")
    private String description;

    //У одного автора много книг.При удалении автора удаляются все его книги
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "author")
    private Collection<Book> bookList;

}
