package com.digital_library.domain;

import com.digital_library.util.PaymentMethod;
import com.digital_library.util.StatusEnum;
import lombok.Data;


import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_order_id_seq", allocationSize = 1)
    @Column (name = "order_id")
    private int id;
    @Column (name = "user_id")
    private int userId;
    @Column (name = "count")
    private int count;
    @Column (name = "amount")
    private int amount;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Column (name = "completion_date")
    private Timestamp completionDate;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
