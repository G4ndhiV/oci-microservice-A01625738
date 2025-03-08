package com.example.oci_microservice.controller;
import com.example.oci_microservice.model.Order;
import com.example.oci_microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/orders")
public class OrderController {
@Autowired
private OrderService orderService;
@PostMapping("/user/{userId}")
public ResponseEntity<Order> createOrder(@PathVariable Long userId, @RequestBody Order
order) {
Order createdOrder = orderService.createOrder(userId, order);
return createdOrder != null ? ResponseEntity.ok(createdOrder) :
ResponseEntity.badRequest().build();
}
@GetMapping
public List<Order> getAllOrders() {
return orderService.getAllOrders();
}
@GetMapping("/user/{userId}")
public List<Order> getOrdersByUser(@PathVariable Long userId) {
return orderService.getOrdersByUser(userId);
}
@GetMapping("/{id}")
public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
Optional<Order> order = orderService.getOrderById(id);
return order.map(ResponseEntity::ok).orElseGet(() ->
ResponseEntity.notFound().build());
}
@PutMapping("/{id}")
public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order
orderDetails) {
Order updatedOrder = orderService.updateOrder(id, orderDetails);
return updatedOrder != null ? ResponseEntity.ok(updatedOrder) :
ResponseEntity.notFound().build();
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
return orderService.deleteOrder(id) ? ResponseEntity.noContent().build() :
ResponseEntity.notFound().build();
}
}