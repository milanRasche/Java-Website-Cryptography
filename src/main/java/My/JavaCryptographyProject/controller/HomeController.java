package My.JavaCryptographyProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{

    @GetMapping("/")
    public String Welcome(Model model) {
    model.addAttribute("message", "Welcome to my java Cryptography Project");
    return "home";
    }
}
