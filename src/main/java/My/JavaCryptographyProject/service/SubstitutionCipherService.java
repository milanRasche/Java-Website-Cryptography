package My.JavaCryptographyProject.service;

import org.springframework.stereotype.Service;

@Service
public class SubstitutionCipherService{
    //The Key is a 26 char string of letter. The mappig is a = key[0], b = key[1], etc.
    public String encrypt(String text, String key){
        StringBuilder stringBuilder = new StringBuilder();
        String lowerKey = key.toLowerCase();
        String upperKey = key.toUpperCase();

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            
            if(Character.isLowerCase(c)){
                int toSubsitute = (int) ((c - 'a') % 26);
                c = lowerKey.charAt(toSubsitute);
            } else if(Character.isUpperCase(c)){
                int toSubsitute = (int) ((c - 'A') % 26);
                c = upperKey.charAt(toSubsitute);
            }

            stringBuilder.append(c);
        }


        return stringBuilder.toString();
    }

    public String decrypt(String text, String key){
        StringBuilder stringBuilder = new StringBuilder();
        String lowerKey = key.toLowerCase();
        String upperKey = key.toUpperCase();


        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLowerCase(c)) {
                int index = lowerKey.indexOf(c);
                if (index != -1) {
                    c = (char) ('a' + index);
                }
            } else if (Character.isUpperCase(c)) {
                int index = upperKey.indexOf(c);
                if (index != -1) {
                    c = (char) ('A' + index);
                }
            }

            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}