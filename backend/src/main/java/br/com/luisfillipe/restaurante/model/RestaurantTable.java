package br.com.luisfillipe.restaurante.model;
import jakarta.persistence.*;
@Entity @Table(name="restaurant_tables")
public class RestaurantTable {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Integer number;
 private Integer capacity;
 private Boolean available=true;
 public Long getId(){return id;} public Integer getNumber(){return number;} public void setNumber(Integer v){number=v;}
 public Integer getCapacity(){return capacity;} public void setCapacity(Integer v){capacity=v;}
 public Boolean getAvailable(){return available;} public void setAvailable(Boolean v){available=v;}
}
