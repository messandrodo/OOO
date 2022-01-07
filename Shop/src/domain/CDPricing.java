package domain;

public class CDPricing implements Pricing {
    @Override
    public Double getPrice(int days) {
        return days * 1.5;
    }
}
