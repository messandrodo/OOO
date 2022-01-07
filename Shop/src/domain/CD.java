package domain;

public class CD extends Product {
    public CD(String title) {
        super(title);
        setPrice(new CDPricing());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
