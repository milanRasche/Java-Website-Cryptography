package My.JavaCryptographyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import My.JavaCryptographyProject.service.SubstitutionCipherService;

@Controller
public class SubstitutionController {

    @Autowired
    private SubstitutionCipherService cipherService;

    @GetMapping("/substitution")
    public String substitutionForm(){
        return "substitution";
    }

     @PostMapping("/substitution/encrypt")
    public String encrpyt(
        @RequestParam("message") String message,
        @RequestParam("key") String key,
        Model model) {

        String encrypted = cipherService.encrypt(message, key);
        model.addAttribute("message", message);
        model.addAttribute("key", key);
        model.addAttribute("encrypted", encrypted);
        return "substitution_encode_result";
    }

    @PostMapping("/substitution/decrypt")
    public String decrypt(
            @RequestParam("message") String message,
            @RequestParam("key") String key,
            Model model) {

        String decrypted = cipherService.decrypt(message, key);
        model.addAttribute("message", message);
        model.addAttribute("key", key);
        model.addAttribute("decrypted", decrypted);
        return "substitution_decode_result";
    }
}