package br.com.luisfillipe.restaurante.repository;
import br.com.luisfillipe.restaurante.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category,Long>{}
