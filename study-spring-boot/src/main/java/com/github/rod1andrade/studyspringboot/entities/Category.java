package com.github.rod1andrade.studyspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade: Category
 *
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_category")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category implements Serializable {

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

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    @Getter
    private final Set<Product> products = new HashSet<>();

}
