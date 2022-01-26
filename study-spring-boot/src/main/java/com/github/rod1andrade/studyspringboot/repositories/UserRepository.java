package com.github.rod1andrade.studyspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.rod1andrade.studyspringboot.entities.User;

/**
 * Repository: User
 * 
 * @author rodri
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
