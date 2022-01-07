package domain;

import java.util.Objects;

public abstract class Product {
    private String title;
    private Pricing price;
    public int days;
    public boolean lent = false;

    public Product(String title){
        setTitle(title);
    }

    private void setTitle(String title) {
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title may not be empty.");
        }
        this.title=title;
    }

    public void setLent(Boolean lent){
        this.lent = lent;
    }
    public boolean getLent(){
        return this.lent;
    }
    public String getTitle() {
        return title;
    }


    public void setPrice (Pricing pricing){
        this.price=pricing;
    }

    public Double getPrice(int days){
        return price.getPrice(days);
    }



    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return ((Product) o).getTitle().equals(this.getTitle());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return this.getTitle() +"  €" + getPrice(5) +"  (" + this.getClass().getSimpleName() + ")  ";
    }


}
