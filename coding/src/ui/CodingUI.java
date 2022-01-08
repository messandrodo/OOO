package ui;


import domain.EncryptionFacade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CodingUI extends VBox{
    private EncryptionFacade encryptionFacade;
    private TextField tekstveld;
    private ComboBox algoritme;
    private Text resultaat;


    public CodingUI(Stage primaryStage) {
        encryptionFacade = new EncryptionFacade();
        Label text = new Label("Typ hier je text");
        Label method = new Label("Selecteer hier welk algoritme je wilt gebruiken: ");

        tekstveld = new TextField();

        algoritme = new ComboBox();
        algoritme.getItems().addAll("Caesar", "Spiegel");

        Button codeer = new Button("Codeer");
        codeer.setOnAction(new Encrypt());
        Button decodeer = new Button("Decodeer");
        decodeer.setOnAction(new Decrypt());

        resultaat = new Text();

        VBox root = new VBox(text, tekstveld, method, algoritme, codeer, decodeer, resultaat);
        Scene main = new Scene(root, 400, 250);
        primaryStage.setTitle("Encryptie");
        primaryStage.setScene(main);

        //css
        text.setPadding(new Insets(10,10,10,10));
      tekstveld.setPadding(new Insets(10,10,10,10));


    }


    private class Encrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String text = tekstveld.getText();
            String method =((String)algoritme.getValue()).toUpperCase();
            resultaat.setText(encryptionFacade.codeer(text, method));
        }
    }

    private class Decrypt implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            String text = tekstveld.getText();
            String method =((String)algoritme.getValue()).toUpperCase();
            resultaat.setText(encryptionFacade.decodeer(text, method));
        }
    }
}

