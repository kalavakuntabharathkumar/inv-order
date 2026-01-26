package com.bharath.user;
import jakarta.persistence.*;
@Entity @Table(name="users",indexes=@Index(name="idx_user_email",columnList="email"))
public class User{ @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id; String name; @Column(unique=true) String email; String role;
 public User(){} public Long getId(){return id;} public String getName(){return name;} public void setName(String x){name=x;} public String getEmail(){return email;} public void setEmail(String x){email=x;} public String getRole(){return role;} public void setRole(String x){role=x;}}
