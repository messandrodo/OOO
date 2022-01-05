package domain;

import domain.database.ShopDatabase;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements Data {
    @Override
    public void setDataAction(Shop shop) {
        ShopDatabase data = new ShopDatabase();
        File shopPath = new File("Shop/src/data/shop.txt");

        try {
            shopPath.createNewFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {
            Scanner scannerFile = new Scanner(shopPath);
            while (scannerFile.hasNextLine()) {
                String s = scannerFile.nextLine();
                String[] delen = s.split("\t");
                String id = delen[0];
                data.addProduct(Integer.parseInt(id), delen[1], delen[2]);
            }
            shop.setDatabase(data);
        } catch (IllegalStateException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
