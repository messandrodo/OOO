package domain.database;

import domain.Game;
import domain.Movie;
import domain.Product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class DatabaseComperator implements Comparator<HashMap.Entry<Integer, Product>> {
    @Override
    public int compare(HashMap.Entry<Integer, Product> e1, Map.Entry<Integer, Product> e2){
        if (e1.getValue() instanceof Movie && (e2.getValue() instanceof Game)){
            return Integer.MIN_VALUE;
        }else if (e1.getValue() instanceof Game) {
            if (e2.getValue() instanceof Movie){
                return Integer.MAX_VALUE;
            }
        }
        return 0;
    }
}