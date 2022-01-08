package Application;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.CodingUI;

public class CodingMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        new CodingUI(primaryStage);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
