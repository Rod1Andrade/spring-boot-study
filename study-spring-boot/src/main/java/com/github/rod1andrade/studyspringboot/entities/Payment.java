package com.github.rod1andrade.studyspringboot.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

/**
 * Entidade: pagamento.
 *
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_payment")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NonNull
    private Instant moment;

    @OneToOne
    @MapsId
    @Getter
    @NonNull
    private Order order;

}
