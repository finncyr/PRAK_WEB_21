package dev.finncyr.today;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.finncyr.today.models.Post;
import dev.finncyr.today.models.UserRepository;

@RestController
public class APIController {

    private final String UPLOAD_DIR = "./src/main/resources/static/";

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

    @GetMapping(value = "/api/posts/{id}/picture", produces = "image/png")
    public byte[] getPostPicture(@PathVariable("id") Long id) throws IOException{
        String fileName = userRepository.findById(id).get().getFilename();
        return Files.readAllBytes(Paths.get(UPLOAD_DIR + fileName));
    }
}
