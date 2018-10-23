package com.elte.alkfejl.recept.repository;

import java.util.Optional;
import com.elte.alkfejl.recept.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}