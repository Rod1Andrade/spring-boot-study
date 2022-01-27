package com.github.rod1andrade.studyspringboot.entities;

import com.github.rod1andrade.studyspringboot.entities.pk.OrderItemPK;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serial;
import java.io.Serializable;

@Entity(name = "tb_order_item")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @EqualsAndHashCode.Include
    private OrderItemPK id;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItem(Product product, Order order, Integer quantity, Double price) {
        id.setProduct(product);
        id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Order getOrder() {
        return id.getOrder();
    }
}
