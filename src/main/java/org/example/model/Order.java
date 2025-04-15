package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name = "customer_name")
    private String customerName;
    @ManyToMany
    @JoinTable(name="order_products",
            joinColumns=  @JoinColumn(name="order_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="product_id", referencedColumnName="id") )
    private List<Product> products;
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return  "\nid=" + id +
                "\ncustomerName=" + customerName +
                "\nproducts=" + products +
                "\ntotalPrice=" + totalPrice + "\n";
    }
}
