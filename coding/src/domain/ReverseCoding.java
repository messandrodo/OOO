package domain;

public class ReverseCoding implements CodingStrategy{
    @Override
    public String code(String text) {
        if (text.equals("")){
            return "";
        } else {
            String firstChar = text.substring(0, 1);
            String restOfTekst = text.substring(1);
            return code(restOfTekst) + firstChar;
        }
    }

    @Override
    public String decode(String text) {
        return code(text);
    }
}
