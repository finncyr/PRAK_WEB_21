package dev.finncyr.today.models;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Post, Long> {
    
    List<Post> findAll();
    Optional<Post> findById(Long id);
}
