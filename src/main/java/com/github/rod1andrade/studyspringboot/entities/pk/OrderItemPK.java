package com.github.rod1andrade.studyspringboot.entities.pk;

import com.github.rod1andrade.studyspringboot.entities.Order;
import com.github.rod1andrade.studyspringboot.entities.Product;
import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

/**
 * Chave primária composta (Product, Order)
 *
 * @author Rodrigo Andrade
 */
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderItemPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @Getter
    @Setter
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @Getter
    @Setter
    private Order order;
}
