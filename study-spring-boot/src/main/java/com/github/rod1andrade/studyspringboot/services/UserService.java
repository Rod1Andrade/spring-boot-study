package com.github.rod1andrade.studyspringboot.services;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.Optional;

import com.github.rod1andrade.studyspringboot.resources.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.rod1andrade.studyspringboot.entities.User;
import com.github.rod1andrade.studyspringboot.repositories.UserRepository;

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
        repository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User prepareUser = repository.getById(id);
        copyUserTo(user, prepareUser);
        return repository.save(prepareUser);
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
