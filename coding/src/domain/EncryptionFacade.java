package domain;

public class EncryptionFacade {
    private static CodingContext codingContext;
    private static CodingFactory factory = new CodingFactory();

    public EncryptionFacade(){

    }

    public String codeer(String text, String method){
        Methods methods = Methods.valueOf(method);
        CodingContext codingContext = factory.createContext(text, methods);
        return codingContext.code();
    }
    public String decodeer(String text, String method){
        Methods methods = Methods.valueOf(method);
        CodingContext codingContext = factory.createContext(text, methods);
        return codingContext.decode();
    }
}
