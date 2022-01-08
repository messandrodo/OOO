package ui;



public class CodingUI {
    private Stage = new Stage();
    private Scene scene;
    private Label resultaatLabel = new Label();
    private Pane root;
    private Button codeer;
    private Button decodeer;
    private TextField tekst;
    private ChoiceBox<String> algoritme;
    private ClickHandler clickHandler;

    public CodingUI() {
        root = createNodeHierarchy();
        scene = new Scene(root, 350, 400);
        stage.setScene(scene);
        stage.setTitle("Coderen");
        stage.show();
    }

    public Pane root() {
        return root;
    }

    public void setResultaatLabel(String s) {
        resultaatLabel.setText(s);
    }

    private Pane createNodeHierarchy() {
        clickHandler = new ClickHandler();
        Label tekstLabel = new Label("Typ tekst");
        tekst = new TextField();
        Label algoLabel = new Label("Kies algoritme");
        algoritme = new ChoiceBox<>();
        algoritme.getItems().addAll("Caesar", "Reverse");
        algoritme.setValue("Caesar");

        codeer = new Button("Codeer");
        decodeer = new Button("Decodeer");

        VBox p = new VBox(8);
        p.setPadding(new Insets(10));
        p.getChildren().addAll
                (tekstLabel, tekst, algoLabel, algoritme, codeer, decodeer, resultaatLabel);
        codeer.setOnAction(clickHandler);
        decodeer.setOnAction(clickHandler);
        return p;
    }

    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            String resultaat = "Tekst; " + tekst.getText() + " gekozen algoritme; " + algoritme.getValue();

            if (e.getSource() == codeer) {
                resultaat += " coderen";
            } else {
                if (e.getSource() == decodeer) {
                    resultaat += " decoderen";
                }
            }
            setResultaatLabel(resultaat);
        }
    }
}

