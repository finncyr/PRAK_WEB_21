package dev.finncyr.today.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Post, Long> {
    
    List<Post> findAll();
}
