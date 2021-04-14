package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Main;
import sample.Modelo.flujoEfectivo;

import javax.swing.*;
import java.sql.Date;

public class flujoController {

    @FXML
    private TableView<flujoEfectivo> tableView;

    @FXML
    private TableColumn<flujoEfectivo, Date> fechaColumn;

    @FXML
    private TableColumn<flujoEfectivo, String> descripcionColumn;

    @FXML
    private TableColumn<flujoEfectivo, String> categoriaColumn;

    @FXML
    private TableColumn<flujoEfectivo, String> subcatColumn;

    @FXML
    private CheckBox entradaCheck;

    @FXML
    private CheckBox salidadCheck;

    @FXML
    private JFXTextField descripcionTextfield;

    @FXML
    private JFXTextField cantidadTextfield;

    @FXML
    private JFXButton guardarBoton;

    @FXML
    private JFXButton regresarBoton;

    @FXML
    private ComboBox<?> categoriaCombo;


    flujoEfectivo flujo = new flujoEfectivo();

    @FXML
    void botonClicked(MouseEvent event) {
        String cadena = cantidadTextfield.getText();
        if(!cadena.matches("[0-9]*\\.?[0-9]*")){
            JOptionPane.showMessageDialog(null,"Cantidad no reconocible, no se guardo la informacion\nIntente nuevamente");
        }else{
            //flujo.setMonto(Float.parseFloat(cadena));
        }
        //System.out.println(flujo.getMonto());
    }

    @FXML
    void regresarClicked(MouseEvent event) {
        Stage stage = (Stage) Main.secondStage.getScene().getWindow();
        stage.close();
        Main.newStage("Menu","Finanzas");
    }

}
