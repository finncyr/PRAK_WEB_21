package dev.finncyr.today;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.finncyr.today.models.Post;
import dev.finncyr.today.models.UserRepository;

@Controller
public class TodayController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        userRepository.save(new Post("01.01.2000", "Testpost", "Hallo Testpost hier", 12345));
        userRepository.save(new Post("01.01.2001", "Testpost 2", "Hallo Testpost 2 hier", 54321));

        model.addAttribute("posts", userRepository.findAll());

        model.addAttribute("title", "Posts");

        return "index";
    }

    @PostMapping("/formhandler")
    public void formhandler()
}
