package br.com.luisfillipe.restaurante.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private OrderEntity order;
 @ManyToOne(optional=false) private Dish dish;
 private Integer quantity;
 private BigDecimal unitPrice;
 public Long getId(){return id;} public OrderEntity getOrder(){return order;} public void setOrder(OrderEntity v){order=v;}
 public Dish getDish(){return dish;} public void setDish(Dish v){dish=v;}
 public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;}
 public BigDecimal getUnitPrice(){return unitPrice;} public void setUnitPrice(BigDecimal v){unitPrice=v;}
}
