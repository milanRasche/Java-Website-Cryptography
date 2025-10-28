package My.JavaCryptographyProject.service;

import org.springframework.stereotype.Service;

@Service
public class CaesarCipherService {
    public String encrypt(String text, int shift){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            
            if(Character.isLowerCase(c)){
                c = (char) ('a' + (c - 'a' + shift) % 26);
            } else if(Character.isUpperCase(c)){
                c = (char) ('A' + (c - 'A' + shift) % 26);
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String decrypt(String text, int shift){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);

            if(Character.isLowerCase(c)){
                c = (char) ('a' + (c - 'a' + (26 - shift)) % 26);
            } else if (Character.isUpperCase(c)) {
                c = (char) ('A' + (c - 'A' + (26 - shift)) % 26);
            }
            stringBuilder.append(c);
        }
        
        return stringBuilder.toString();
    }
}
