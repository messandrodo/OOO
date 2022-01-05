package ui;

import domain.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopUI {
    private Shop shop;
    private Data data;

    public ShopUI(){
        this.shop = new Shop();
    }
    public void start() {
        int choice = -1;
        Shop shop = new Shop();
        String menu = "\n1. Add product" +
                "\n2. Remove product" +
                "\n3. Loan product" +
                "\n4. Product loaned?" +
                "\n5. Return product" +
                "\n6. Repair product" +
                "\n7. Show product" +
                "\n8. Show rental price" +
                "\n9. Show list of products" +
                "\n\n0. Quit";

        Scanner myObj = new Scanner(System.in);

        setData(new TextReader());
        data.setDataAction(shop);

        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1){
                addProduct(shop);
            } else if (choice == 7) {
                showProduct(shop);
            } else if (choice == 8) {
                showPrice(shop);
            } else if (choice == 9){
                listProducts(shop);
            } else if (choice == 0){
                setData(new TextWriter());
                data.setDataAction(shop);
                System.exit(0);
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/CD for CD):");

        shop.getShopDatabase().addProduct(title, type);
        shop.writeData();
    }

//    public static void removeProduct(Shop shop){
//        String id = JOptionPane.showInputDialog("Enter the id:");
//
//        try {
//            Product product = shop.getShopDatabase().getProduct(id);
//            JOptionPane.showMessageDialog(null, product.removeProduct());
//        } catch (Exception exc){
//            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
//        }
//    }

    public static void showProduct(Shop shop){
        String id = JOptionPane.showInputDialog("Enter the id:");
        /*int idx = -1;
        boolean found = false;*/
        try {
            Product product = shop.getShopDatabase().getProduct(id);
            JOptionPane.showMessageDialog(null, product.toString());
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Er is geen product gevonden");
        }
    }

    public static void showPrice(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");

        Product product = shop.getShopDatabase().getProduct(id);
        if (product != null){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, "The total price would amount to $" + shop.getPrice(id, days));
        }
    }

    public static void listProducts(Shop shop){
        ArrayList<HashMap.Entry<Integer, Product>> list = shop.getShopDatabase().getProducts();
        String output = "";
        for (HashMap.Entry<Integer, Product> item: list){
            output += item.getKey() + ": " + item.getValue().toString() + "\n";
        }
        if (output.isEmpty()) output += "Er zijn nog geen producten";
        JOptionPane.showMessageDialog(null, output);
    }

    public void setData(Data data) {
        this.data = data;
    }
}
