package sample.Vista;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sample.Main;
import sample.Recursos.coneccionAudio;

import java.net.URL;
import java.util.ResourceBundle;

public class menuController implements Initializable {

    @FXML
    private JFXButton botonCategorias;

    @FXML
    private JFXButton botonFlujo;

    @FXML
    private JFXButton botonIndicador;

    private coneccionAudio audio = new coneccionAudio();

    @FXML
    void categorias_on_mouse_clicked(MouseEvent event) {
        Main.newStage("categorias","Categorias");
        Stage stage = (Stage) Main.primaryStages.getScene().getWindow();
        stage.close();
    }

    @FXML
    void flujoEfectivo_on_mouse_clicked(MouseEvent event) {
        Main.newStage("flujoEfectivo","Flujo");
        Stage stage = (Stage) Main.primaryStages.getScene().getWindow();
        stage.close();
    }

    @FXML
    void indicadorDinero_on_mouse_clicked(MouseEvent event) {
        Main.newStage("registroInfo","Indicadores");
        Stage stage = (Stage) Main.primaryStages.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

