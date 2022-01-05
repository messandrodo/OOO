package domain;

import domain.database.ShopDatabase;

public class Shop {
    private ShopDatabase shopDatabase;

    public Shop(){
        this.shopDatabase = new ShopDatabase();
    }

    public ShopDatabase getShopDatabase(){
        return this.shopDatabase;
    }

    public void setDatabase(ShopDatabase shopDatabase){
        this.shopDatabase = shopDatabase;
        this.shopDatabase.setLatestPid();
    }

    public double getPrice(String id, int days){
        Product product = this.shopDatabase.getProduct(id);
        product.days = days;
        return product.getPrice(days);
    }
}
