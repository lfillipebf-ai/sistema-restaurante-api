package br.com.luisfillipe.restaurante.repository;
import br.com.luisfillipe.restaurante.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer,Long>{}
