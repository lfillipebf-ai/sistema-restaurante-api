package br.com.luisfillipe.restaurante.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;
@Entity @Table(name="orders")
public class OrderEntity {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Customer customer;
 @ManyToOne private RestaurantTable tableRef;
 @Enumerated(EnumType.STRING) private OrderStatus status=OrderStatus.RECEIVED;
 private BigDecimal total=BigDecimal.ZERO;
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>();
 public Long getId(){return id;} public Customer getCustomer(){return customer;} public void setCustomer(Customer v){customer=v;}
 public RestaurantTable getTableRef(){return tableRef;} public void setTableRef(RestaurantTable v){tableRef=v;}
 public OrderStatus getStatus(){return status;} public void setStatus(OrderStatus v){status=v;}
 public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal v){total=v;}
 public List<OrderItem> getItems(){return items;}
}
