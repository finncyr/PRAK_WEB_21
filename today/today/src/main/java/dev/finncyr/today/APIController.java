package dev.finncyr.today;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.finncyr.today.models.Post;
import dev.finncyr.today.models.UserRepository;

@RestController
public class APIController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping(value = "/api/posts", produces ="application/json")
    public List<Post> getPosts() {
        return  userRepository.findAll();
    }

    @GetMapping(value = "/api/posts/{id}", produces = "application/json")
    public Post getPostById(@PathVariable("id") Long id){
        return userRepository.findById(id).get();
    }
}
