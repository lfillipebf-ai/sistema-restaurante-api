package br.com.luisfillipe.restaurante.controller;
import br.com.luisfillipe.restaurante.model.Customer;
import br.com.luisfillipe.restaurante.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/customers")
public class CustomerController {
 private final CustomerRepository repo; public CustomerController(CustomerRepository repo){this.repo=repo;}
 @GetMapping public List<Customer> list(){return repo.findAll();}
 @PostMapping public Customer create(@Valid @RequestBody Customer c){return repo.save(c);}
}
