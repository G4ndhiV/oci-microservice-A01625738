package com.example.oci_microservice.model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
@Entity
@Table(name = "orders")
@Data
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String productName;
private int quantity;
private double price;
@Temporal(TemporalType.TIMESTAMP)
private Date orderDate = new Date();
@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
private User user;
}