package br.com.luisfillipe.restaurante.repository;
import br.com.luisfillipe.restaurante.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DishRepository extends JpaRepository<Dish,Long>{}
