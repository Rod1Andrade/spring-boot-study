package com.github.rod1andrade.studyspringboot.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.rod1andrade.studyspringboot.enums.OrderStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entidade: Order
 *
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_order")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    @Getter
    @Setter
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private User client;

    @OneToMany(mappedBy = "id.order")
    @Getter
    @ToString.Exclude
    private final Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        assert orderStatus != null;
        this.orderStatus = orderStatus.getCode();
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(this.orderStatus);
    }

}
