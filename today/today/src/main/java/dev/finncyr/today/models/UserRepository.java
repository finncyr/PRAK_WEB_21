package dev.finncyr.today.models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Post, Long> {
    
}