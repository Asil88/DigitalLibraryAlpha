package com.digital_library.domain;

import com.digital_library.util.PaymentMethod;
import com.digital_library.util.StatusEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_order_id_seq", allocationSize = 1)*/
    @Column (name = "order_id")
    private int id;
    //У одной Корзины может быть один Юзер
    /*@JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;*/

    @Column (name = "count")
    private int count;
    @Column (name = "amount")
    private int amount;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column (name = "completion_date")
    private Timestamp completionDate;
    @Column(name = "payment_method",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    //Множество корзин разных юзеров могут иметь в них много книг
    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "orders_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Collection<Book>books;
}
