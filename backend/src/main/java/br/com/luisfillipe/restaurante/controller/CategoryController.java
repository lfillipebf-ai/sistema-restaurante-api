package br.com.luisfillipe.restaurante.controller;
import br.com.luisfillipe.restaurante.model.Category;
import br.com.luisfillipe.restaurante.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/categories")
public class CategoryController {
 private final CategoryRepository repo; public CategoryController(CategoryRepository repo){this.repo=repo;}
 @GetMapping public List<Category> list(){return repo.findAll();}
 @PostMapping public Category create(@Valid @RequestBody Category c){return repo.save(c);}
}
