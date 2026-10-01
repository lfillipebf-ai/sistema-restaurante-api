package br.com.luisfillipe.restaurante.controller;
import br.com.luisfillipe.restaurante.model.*;
import br.com.luisfillipe.restaurante.repository.*;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController @RequestMapping("/api/orders")
public class OrderController {
 private final OrderRepository orders; private final CustomerRepository customers; private final DishRepository dishes; private final RestaurantTableRepository tables;
 public OrderController(OrderRepository o,CustomerRepository c,DishRepository d,RestaurantTableRepository t){orders=o;customers=c;dishes=d;tables=t;}
 @GetMapping public List<OrderEntity> list(){return orders.findAll();}
 @PostMapping @Transactional
 public ResponseEntity<OrderEntity> create(@RequestBody CreateOrderRequest req){
  Customer c=customers.findById(req.customerId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
  OrderEntity order=new OrderEntity(); order.setCustomer(c);
  if(req.tableId()!=null) order.setTableRef(tables.findById(req.tableId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Mesa não encontrada")));
  BigDecimal total=BigDecimal.ZERO;
  for(ItemRequest item:req.items()){
   Dish dish=dishes.findById(item.dishId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Prato não encontrado"));
   if(!Boolean.TRUE.equals(dish.getAvailable())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Prato indisponível");
   OrderItem oi=new OrderItem(); oi.setOrder(order); oi.setDish(dish); oi.setQuantity(item.quantity()); oi.setUnitPrice(dish.getPrice());
   order.getItems().add(oi); total=total.add(dish.getPrice().multiply(BigDecimal.valueOf(item.quantity())));
  }
  order.setTotal(total); return ResponseEntity.status(HttpStatus.CREATED).body(orders.save(order));
 }
 @PatchMapping("/{id}/status")
 public OrderEntity status(@PathVariable Long id,@RequestParam OrderStatus value){
  OrderEntity o=orders.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Pedido não encontrado"));
  o.setStatus(value); return orders.save(o);
 }
 public record CreateOrderRequest(Long customerId,Long tableId,List<ItemRequest> items){}
 public record ItemRequest(Long dishId,Integer quantity){}
}
