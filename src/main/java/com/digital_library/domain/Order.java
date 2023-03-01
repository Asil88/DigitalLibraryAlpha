package com.digital_library.domain;

import com.digital_library.util.PaymentMethod;
import com.digital_library.util.StatusEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Component
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    private int user_id;
    private int count;
    private int amount;
    private StatusEnum status;
    private Timestamp completion_date;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
