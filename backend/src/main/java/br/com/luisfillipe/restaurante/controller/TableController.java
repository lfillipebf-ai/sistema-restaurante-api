package br.com.luisfillipe.restaurante.controller;
import br.com.luisfillipe.restaurante.model.RestaurantTable;
import br.com.luisfillipe.restaurante.repository.RestaurantTableRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tables")
public class TableController {
 private final RestaurantTableRepository repo; public TableController(RestaurantTableRepository repo){this.repo=repo;}
 @GetMapping public List<RestaurantTable> list(){return repo.findAll();}
 @PostMapping public RestaurantTable create(@RequestBody RestaurantTable t){return repo.save(t);}
}
