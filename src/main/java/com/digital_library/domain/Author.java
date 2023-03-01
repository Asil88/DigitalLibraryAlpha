package com.digital_library.domain;



import com.digital_library.util.PaymentMethod;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "authors")
@Data
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

}
