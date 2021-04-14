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
        Main.setFXML("registroInfo","Indicadores de dinero");
    }

    @FXML
    void reporteClicked(MouseEvent event) {
        
    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }
}
