package domain;

public interface CodingStrategy {

    String code(String text);
    String decode(String text);
}
