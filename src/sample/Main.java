package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Adaptador.adaptadorSql;

import java.io.IOException;

public class Main extends Application {

    public static Scene scene;
    public static Stage primaryStages;
    public static Stage secondStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        adaptadorSql adaptador = new adaptadorSql();
        adaptador.getConnection();
        primaryStages = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Vista/Menu.fxml"));
        primaryStages.setTitle("Hello World");
        primaryStages.setScene(new Scene(root));
        primaryStages.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Vista/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void newStage(String fxml, String title) {
        try {
            secondStage = new Stage();
            Scene scene = new Scene(loadFXML(fxml));
            secondStage.setScene(scene);
            secondStage.setTitle(title);
            secondStage.setResizable(false);
            secondStage.initModality(Modality.WINDOW_MODAL);
            secondStage.centerOnScreen();
            secondStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
