package com.github.rod1andrade.studyspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Entidade: Produto
 *
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_product")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Double price;

    @Getter
    @Setter
    private String imageUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @Getter
    private final Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private final Set<OrderItem> items = new HashSet<>();

    @JsonIgnore
    public Set<Order> getOrders() {
        return items.stream().map(OrderItem::getOrder).collect(Collectors.toSet());
    }
}
