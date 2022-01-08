package domain;

public class CodingContext {
    private String text;
    private CodingStrategy method;


    public  CodingContext(){
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setCodingStratagy(CodingStrategy method){
        this.method = method;

    }
    public CodingStrategy getMethod(){
        return this.method;
    }

    public String code(){
        return this.getMethod().code(this.getText());
    }
    public String decode(){
        return this.getMethod().decode(this.getText());
    }
}
