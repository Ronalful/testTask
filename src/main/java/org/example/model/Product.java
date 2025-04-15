package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private BigDecimal price;
//    @ManyToMany
//    private List<Order> orders;

    @Override
    public String toString() {
        return "\n\tid=" + id +
                "\n\tname=" + name +
                "\n\tprice=" + price + "\n";
    }
}
