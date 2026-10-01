package br.com.luisfillipe.restaurante.repository;
import br.com.luisfillipe.restaurante.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{}
