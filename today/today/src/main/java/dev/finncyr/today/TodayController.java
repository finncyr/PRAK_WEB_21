package dev.finncyr.today;

import java.io.IOException;
import java.lang.reflect.Member;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.finncyr.today.models.Post;
import dev.finncyr.today.models.UserRepository;

@Controller
public class TodayController {

    private final String UPLOAD_DIR = "./src/main/resources/static/";

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts", userRepository.findAll());

        model.addAttribute("title", "Posts");

        return "index";
    }

    @GetMapping("/seite1")
    public String seite1(Model model) {

        model.addAttribute("posts", userRepository.findAll());

        model.addAttribute("title", "Posts");

        return "seite1";
    }

    @GetMapping("/seite3")
    public String seite3(Model model) {
        model.addAttribute("title", "New Post");
        return "seite3";
    }

    @PostMapping(path = "/form", consumes = "multipart/form-data")
    public String formHandler(
        @RequestParam("datum") String datum,
        @RequestParam("titel") String title,
        @RequestParam("textfeld") String text,
        @RequestParam("steps") int steps,
        @RequestParam("picture") MultipartFile picture,
        RedirectAttributes attributes) {

            // check if file is empty
            if (picture.isEmpty()) {
                attributes.addFlashAttribute("message", "Please select a file to upload.");
                return "redirect:/seite3";
            }

            String fileName = StringUtils.cleanPath(picture.getOriginalFilename());

            try {
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.copy(picture.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            attributes.addFlashAttribute("message", "You successfully posted!");
        
            userRepository.save(new Post(datum, title, text, steps, fileName));
            return "redirect:/seite1";
    }
}
