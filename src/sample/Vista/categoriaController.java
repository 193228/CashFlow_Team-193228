package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;

public class categoriaController {

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> clasificacionColumn;

    @FXML
    private TableColumn<?, ?> categoriaColumn;

    @FXML
    private TableColumn<?, ?> subcatColumn;

    @FXML
    private JFXTextField categoriaTextfield;

    @FXML
    private JFXTextField subTextfield;

    @FXML
    private JFXButton botonCategorias;

    @FXML
    private ComboBox<String> calsificacionCombo;

    @FXML
    private JFXButton regresarBoton;

    @FXML
    void botonClicked(MouseEvent event) {

    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }
}
