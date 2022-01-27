package com.github.rod1andrade.studyspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

/**
 * Entidade: Usuário
 * 
 * @author Rodrigo Andrade
 */
@Entity(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User implements Serializable {

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
	private String email;

	@Getter
	@Setter
	private String phone;

	@Getter
	@Setter
	private String password;

	@OneToMany(mappedBy = "client")
	@JsonIgnore
	@Getter
	private final List<Order> orders = new ArrayList<>();

}
