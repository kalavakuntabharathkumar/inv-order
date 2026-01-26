package com.bharath.user;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/users") public class UserController{
 private final UserRepository r; public UserController(UserRepository r){this.r=r;}
 @GetMapping public List<User> all(){return r.findAll();} @GetMapping("/{id}") public User one(@PathVariable Long id){return r.findById(id).orElseThrow();}
 @PostMapping public User create(@RequestBody User u){return r.save(u);}
}
