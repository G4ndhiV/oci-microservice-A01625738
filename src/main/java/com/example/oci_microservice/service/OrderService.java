package com.example.oci_microservice.service;
import com.example.oci_microservice.model.Order;
import com.example.oci_microservice.model.User;
import com.example.oci_microservice.repository.OrderRepository;
import com.example.oci_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;
@Autowired
private UserRepository userRepository;
public Order createOrder(Long userId, Order order) {
Optional<User> user = userRepository.findById(userId);
if (user.isPresent()) {
order.setUser(user.get());
return orderRepository.save(order);
}
return null; // Or throw an exception
}
public List<Order> getAllOrders() {
return orderRepository.findAll();
}
public List<Order> getOrdersByUser(Long userId) {
return orderRepository.findByUserId(userId);
}
public Optional<Order> getOrderById(Long id) {
return orderRepository.findById(id);
}
public Order updateOrder(Long id, Order orderDetails) {
return orderRepository.findById(id).map(order -> {
order.setProductName(orderDetails.getProductName());
order.setQuantity(orderDetails.getQuantity());
order.setPrice(orderDetails.getPrice());
return orderRepository.save(order);
}).orElse(null);
}
public boolean deleteOrder(Long id) {
if (orderRepository.existsById(id)) {
orderRepository.deleteById(id);
return true;
}
return false;
}
}