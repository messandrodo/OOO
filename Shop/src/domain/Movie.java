package domain;

public class Movie extends Product{
    public Movie(String title) {
        super(title);
        setPrice(new MoviePricing());
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
