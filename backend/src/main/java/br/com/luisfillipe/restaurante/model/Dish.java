package br.com.luisfillipe.restaurante.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
@Entity @Table(name="dishes")
public class Dish {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name;
 @NotNull @Positive private BigDecimal price;
 private Boolean available=true;
 @ManyToOne(optional=false) private Category category;
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public Boolean getAvailable(){return available;} public void setAvailable(Boolean v){available=v;}
 public Category getCategory(){return category;} public void setCategory(Category v){category=v;}
}
