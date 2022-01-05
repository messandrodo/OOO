package domain;

public class GamePricing implements  Pricing{
    @Override
    public Double getPrice(int days) {
        return days * 3.0;
    }
}
