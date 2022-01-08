package domain;

import java.lang.reflect.Constructor;

public class CodingFactory {
    public CodingContext createContext(String text, Methods type){
        CodingContext codingContext = new CodingContext();
        CodingStrategy codingMethod = null;

        if(type.equals(Methods.CAESAR)){
            codingMethod = new CaesarCoding();
        } else if (type.equals(Methods.SPIEGEL)){
            codingMethod = new ReverseCoding();
        }
        codingContext.setText(text);
        codingContext.setCodingStratagy(codingMethod);
        return codingContext;

    }
}
