package com.bharath.order;
import jakarta.persistence.*; import java.time.Instant;
@Entity @Table(name="orders",indexes=@Index(name="idx_order_user",columnList="userId"))
public class OrderEntity{@Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; Long userId; String sku; int quantity; double total; String status; Instant createdAt=Instant.now();
 public OrderEntity(){} public Long getId(){return id;} public Long getUserId(){return userId;} public void setUserId(Long x){userId=x;} public String getSku(){return sku;} public void setSku(String x){sku=x;} public int getQuantity(){return quantity;} public void setQuantity(int x){quantity=x;} public double getTotal(){return total;} public void setTotal(double x){total=x;} public String getStatus(){return status;} public void setStatus(String x){status=x;} public Instant getCreatedAt(){return createdAt;}}
