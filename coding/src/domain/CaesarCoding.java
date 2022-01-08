package domain;

import java.util.Locale;

public class CaesarCoding implements CodingStrategy{
    public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
    public static final String caesar = "xyzabcdefghijklmnopqrstuvw";
    @Override
    public String code(String text) {
        String result = "";
        for (int i = 0; i != text.length();i++){
            String next = text.substring(i, i + 1).toLowerCase();
            if(alpha.contains(next)){
                for(int j= 0; j != alpha.length(); j++){
                    if(next.equals(alpha.substring(j, j+1))){
                        result += caesar.charAt(j);
                    }
                }
            } else {
                result += text.charAt(i);
            }
        }
        return result;

    }

    @Override
    public String decode(String text) {
        String result = "";
        for (int i = 0; i != text.length();i++){
            String next = text.substring(i, i + 1).toLowerCase();
            if(caesar.contains(next)){
                for(int j= 0; j != caesar.length(); j++){
                    if(next.equals(caesar.substring(j, j+1))){
                        result += alpha.charAt(j);
                    }
                }
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }
}
