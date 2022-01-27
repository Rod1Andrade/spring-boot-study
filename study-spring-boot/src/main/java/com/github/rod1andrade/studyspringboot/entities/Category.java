package com.github.rod1andrade.studyspringboot.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

/**
 * Entidade: Category
 *
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_category")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

}
