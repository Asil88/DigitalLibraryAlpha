package com.digital_library.domain;

import java.sql.Timestamp;

public class Order {
private int id;
private int user_id;
private int count;
private int amount;
private boolean status;
private Timestamp completion_date;
private  String payment_method;
}
