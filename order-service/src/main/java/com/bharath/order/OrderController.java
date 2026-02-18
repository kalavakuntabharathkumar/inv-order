package com.bharath.order;
import org.springframework.beans.factory.annotation.Value; import org.springframework.web.bind.annotation.*; import org.springframework.web.client.RestClient; import java.util.*;
@RestController @RequestMapping("/api/orders") public class OrderController{
 private final OrderRepository r; private final RestClient client; private final String inventoryUrl;
 public OrderController(OrderRepository r,@Value("${inventory.service.url}")String u){this.r=r;this.inventoryUrl=u;this.client=RestClient.builder().build();}
 @GetMapping public List<OrderEntity> all(){return r.findAll();}
 @PostMapping public OrderEntity create(@RequestBody OrderEntity o){
  var product=client.get().uri(inventoryUrl+"/api/products/"+o.getSku()).retrieve().body(ProductView.class);
  if(product==null||product.stock<o.getQuantity())throw new IllegalArgumentException("Insufficient inventory");
  client.patch().uri(inventoryUrl+"/api/products/"+o.getSku()+"/reserve?quantity="+o.getQuantity()).retrieve().toBodilessEntity();
  o.setTotal(product.price*o.getQuantity());o.setStatus("CONFIRMED");return r.save(o);
 }
 static class ProductView{public double price;public int stock;}
}
