package com.bharath.inventory;
import jakarta.persistence.*;
@Entity @Table(name="products",indexes={@Index(name="idx_product_sku",columnList="sku"),@Index(name="idx_product_stock",columnList="stock")})
public class Product{ @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; @Column(unique=true) String sku; String name; double price; int stock;
 public Product(){} public Long getId(){return id;} public String getSku(){return sku;} public void setSku(String x){sku=x;} public String getName(){return name;} public void setName(String x){name=x;} public double getPrice(){return price;} public void setPrice(double x){price=x;} public int getStock(){return stock;} public void setStock(int x){stock=x;}}
