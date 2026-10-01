package br.com.luisfillipe.restaurante.repository;
import br.com.luisfillipe.restaurante.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable,Long>{}
