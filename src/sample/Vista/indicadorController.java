package sample.Vista;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;

public class indicadorController {

    @FXML
    private JFXButton botonRegistro;

    @FXML
    private JFXButton botonReporte;

    @FXML
    private JFXButton regresarBoton;

    @FXML
    void registroClicked(MouseEvent event) {
        Main.newStage("registroInfo","Registro de informacion");
        Stage stage = (Stage) Main.primaryStages.getScene().getWindow();
        stage.close();
    }

    @FXML
    void reporteClicked(MouseEvent event) {

    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Stage stage = (Stage) Main.secondStage.getScene().getWindow();
        stage.close();
        Main.newStage("Menu","Finanzas");
    }
}
