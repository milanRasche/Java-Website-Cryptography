package My.JavaCryptographyProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import My.JavaCryptographyProject.service.CaesarCipherService;

@Controller
public class CaesarController {
    
    @Autowired
    private CaesarCipherService cipherService;

    @GetMapping("/caesar")
    public String caesarForm(){
        return "caesar";
    }

    @PostMapping("/caesar/encrypt")
    public String encrpyt(
        @RequestParam("message") String message,
        @RequestParam("shift") int shift,
        Model model) {

        String encrypted = cipherService.encrypt(message, shift);
        model.addAttribute("message", message);
        model.addAttribute("shift", shift);
        model.addAttribute("encrypted", encrypted);
        return "caesar_result";
    }

    @PostMapping("/caesar/decrypt")
    public String decrypt(
            @RequestParam("message") String message,
            @RequestParam("shift") int shift,
            Model model) {

        String decrypted = cipherService.decrypt(message, shift);
        model.addAttribute("message", message);
        model.addAttribute("shift", shift);
        model.addAttribute("decrypted", decrypted);
        return "decrypt_caesar_result";
    }

}
