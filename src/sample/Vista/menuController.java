package sample.Vista;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import sample.Datos.entidadCategorias;
import sample.Main;
import sample.Modelo.crudCategorias;
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
        Main.setFXML("categorias","Categorias");
    }

    @FXML
    void flujoEfectivo_on_mouse_clicked(MouseEvent event) {
        Main.setFXML("flujoEfectivo","Flujo de Efectivo");
    }

    @FXML
    void indicadorDinero_on_mouse_clicked(MouseEvent event) {
        Main.setFXML("indicadorDinero","Indicadores de dinero");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //entidadCategorias entidad = new entidadCategorias("1","GAO","122");
        //crudCategorias id = new crudCategorias();
        //id.obtenerId(entidad);
    }
}

