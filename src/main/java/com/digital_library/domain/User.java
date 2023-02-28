package com.digital_library.domain;

import com.digital_library.util.PaymentMethod;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_user_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "e-mail")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @Enumerated(EnumType.STRING)
    @Type(type = "com.digital_library.util.EnumTypePostgreSql")
    private PaymentMethod paymentMethod;
}