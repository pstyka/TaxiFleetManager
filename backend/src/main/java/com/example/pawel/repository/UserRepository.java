package com.example.pawel.repository;


import com.example.pawel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    List<User> findAllByFirstNameIsLikeIgnoreCase(String firstName);

    List<User> findAllByLastNameIsLikeIgnoreCase(String lastName);

    List<User> findAllByFirstNameIsLikeIgnoreCaseAndLastNameIsLikeIgnoreCase(String firstName, String lastName);

}
