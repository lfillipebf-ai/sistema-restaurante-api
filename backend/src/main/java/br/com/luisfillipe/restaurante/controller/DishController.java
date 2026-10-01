package br.com.luisfillipe.restaurante.controller;
import br.com.luisfillipe.restaurante.model.Dish;
import br.com.luisfillipe.restaurante.repository.DishRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/dishes")
public class DishController {
 private final DishRepository repo; public DishController(DishRepository repo){this.repo=repo;}
 @GetMapping public List<Dish> list(){return repo.findAll();}
 @PostMapping public Dish create(@Valid @RequestBody Dish d){return repo.save(d);}
 @PatchMapping("/{id}/availability")
 public Dish availability(@PathVariable Long id,@RequestParam Boolean value){
  Dish d=repo.findById(id).orElseThrow(); d.setAvailable(value); return repo.save(d);
 }
}
