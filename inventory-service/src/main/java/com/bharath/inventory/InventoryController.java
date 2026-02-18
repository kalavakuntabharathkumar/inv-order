package com.bharath.inventory;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/products") public class InventoryController{
 private final ProductRepository r; public InventoryController(ProductRepository r){this.r=r;}
 @GetMapping public List<Product> all(){return r.findAll();} @GetMapping("/{sku}") public Product one(@PathVariable String sku){return r.findBySku(sku).orElseThrow();}
 @PostMapping public Product create(@RequestBody Product p){return r.save(p);}
 @PatchMapping("/{sku}/reserve") public Product reserve(@PathVariable String sku,@RequestParam int quantity){Product p=r.findBySku(sku).orElseThrow();if(p.getStock()<quantity)throw new IllegalArgumentException("Insufficient stock");p.setStock(p.getStock()-quantity);return r.save(p);}
}
