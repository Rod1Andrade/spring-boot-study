package com.github.rod1andrade.studyspringboot.services;

import java.util.List;
import java.util.Optional;

import com.github.rod1andrade.studyspringboot.services.exceptions.DatabaseException;
import com.github.rod1andrade.studyspringboot.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.github.rod1andrade.studyspringboot.entities.User;
import com.github.rod1andrade.studyspringboot.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser(Long id, User user) {
        User prepareUser = repository.getById(id);
        copyUserTo(user, prepareUser);
        try {
            return repository.save(prepareUser);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    /**
     * Copia os valores da origem para o destino.
     *
     * @param user        Origem
     * @param prepareUser destino
     */
    private void copyUserTo(User user, User prepareUser) {
        prepareUser.setName(user.getName());
        prepareUser.setEmail(user.getEmail());
        prepareUser.setPhone(user.getPhone());
    }
}
