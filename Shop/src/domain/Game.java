package domain;

public class Game extends Product{
    public Game(String title) {
        super(title);
        setPrice(new GamePricing());
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
