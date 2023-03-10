package com.digital_library.service;

import com.digital_library.domain.Order;
import com.digital_library.domain.User;
import com.digital_library.repository.OrderRepository;
import com.digital_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    public OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {this.orderRepository = orderRepository;}
    public ArrayList<Order> getAllOrders() {return orderRepository.getAllOrders();}
    public Order getOrderById(int id) {return orderRepository.getOrderById(id);}
    public void createOrder(Order order) {orderRepository.createOrder(order);}
    public void updateOrderById(Order order) {
        orderRepository.updateOrder(order);
    }
    public void deleteOrder(Order order) {orderRepository.deleteOrder(order);}
}
