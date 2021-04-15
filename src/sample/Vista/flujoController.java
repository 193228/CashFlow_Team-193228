package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.Datos.categorio_flujo_table;
import sample.Datos.entidadCategorias;
import sample.Datos.entidadFlujoEfectivo;
import sample.Main;
import sample.Modelo.crudCategorias;
import sample.Modelo.crudFlujoEfectivo;

import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class flujoController implements Initializable {

    @FXML
    private TableView<categorio_flujo_table> tableView;

    @FXML
    private TableColumn<categorio_flujo_table, String> fechaColumn;

    @FXML
    private TableColumn<categorio_flujo_table, String> descripcionColumn;

    @FXML
    private TableColumn<categorio_flujo_table, String> categoriaColumn;

    @FXML
    private TableColumn<categorio_flujo_table, String> subcatColumn;

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
    private ComboBox<String> categoriaCombo;

    private boolean lock;
    private entidadFlujoEfectivo flujo = new entidadFlujoEfectivo();
    private categorio_flujo_table tabla = new categorio_flujo_table();
    private crudCategorias listaCategoria = new crudCategorias();
    private crudFlujoEfectivo efectivo = new crudFlujoEfectivo();
    private ArrayList<entidadCategorias> categoria;
    private ObservableList<categorio_flujo_table> flujo_Efectivo;

    @FXML
    void botonClicked(MouseEvent event) {
        if(tableView.getSelectionModel().getSelectedItems().toString().length() ==2){
            flujo.obtenerFecha();
            flujo.setIdCategoria(categoriaCombo.getSelectionModel().getSelectedIndex()+1);
            flujo.setDescripcion(descripcionTextfield.getText());
            flujo.setMonto(Float.parseFloat(cantidadTextfield.getText()));
            validarCheck();
            entidadFlujoEfectivo add = new entidadFlujoEfectivo(flujo.getIdCategoria(),flujo.getFecha(),flujo.getDescripcion(),flujo.getMonto(),flujo.getTipoOperacion());
            validarRegistro(add);
            efectivo.insert(add);
        }else if(tableView.getSelectionModel().getSelectedItems().toString().length() >2){
            flujo.setIdCategoria(categoriaCombo.getSelectionModel().getSelectedIndex()+1);
            flujo.obtenerFecha();
            flujo.setDescripcion(descripcionTextfield.getText());
            flujo.setMonto(Float.parseFloat(cantidadTextfield.getText()));
            validarCheck();
            flujo.setDescripcionNueva(descripcionTextfield.getText());
            flujo.setMontoNuevo(Float.parseFloat(cantidadTextfield.getText()));
            validarCheck2();
            if(flujo.getDescripcion().length()==0){
                JOptionPane.showMessageDialog(null,"No se pueden dejar campos vacios\nIntente nuevamente");
            }else{
                entidadFlujoEfectivo edit = new entidadFlujoEfectivo(flujo.getIdCategoria(),flujo.getFecha(),flujo.getDescripcion(),flujo.getMonto(),flujo.getTipoOperacion(),flujo.getDescripcionNueva(),flujo.getMontoNuevo(),flujo.getTipoOperacionNuevo());
                efectivo.update(edit);
            }
        }
        mostrarTablas();
    }

    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mostrarCategorias();
        mostrarTablas();
    }

    public void validarRegistro(entidadFlujoEfectivo flujo){
        for(int i=0; i<tableView.getItems().size(); i++){
            if(categoriaCombo.getSelectionModel().getSelectedItem().contains(tableView.getItems().get(i).getCategoria()+tableView.getItems().get(i).getSubCategoria())){
                System.out.println("SE REPITE"); //asi es
            }else{
                System.out.println("ADELANTE INSERTA");
            }
        }
    }

    public void mostrarTablas(){
        flujo_Efectivo = FXCollections.observableList(efectivo.getAllFlujo());
        tableView.setItems(flujo_Efectivo);
        fechaColumn.setCellValueFactory(new PropertyValueFactory<categorio_flujo_table,String>("fecha"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<categorio_flujo_table,String>("descripcion"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<categorio_flujo_table,String>("categoria"));
        subcatColumn.setCellValueFactory(new PropertyValueFactory<categorio_flujo_table,String>("subCategoria"));
    }

    public void mostrarCategorias(){
        categoria = listaCategoria.getAllCategorias();
        for(entidadCategorias entidadCategorias: categoria){
            categoriaCombo.getItems().add(entidadCategorias.getCategoria()+"  -  "+entidadCategorias.getSubcategoria()+"  -  "+entidadCategorias.getClasificacion());
        }
    }

    public void validarCheck(){
        if(!entradaCheck.isSelected() && !salidadCheck.isSelected()){
            JOptionPane.showMessageDialog(null,"Seleccione si el flujo es ingreso o egreso");
        }
        if(entradaCheck.isSelected() && salidadCheck.isSelected()){
            JOptionPane.showMessageDialog(null,"Seleccione solamente si es ingreso o egreso\nNo puede colocar los dos");
        }
        if(entradaCheck.isSelected() && !salidadCheck.isSelected()){
            flujo.setTipoOperacion("ingreso");
        }
        if(salidadCheck.isSelected() && !entradaCheck.isSelected()){
            flujo.setTipoOperacion("egreso");
        }
    }

    public void validarCheck2(){
        if(!entradaCheck.isSelected() && !salidadCheck.isSelected()){
            JOptionPane.showMessageDialog(null,"Seleccione si el flujo es ingreso o egreso");
        }
        if(entradaCheck.isSelected() && salidadCheck.isSelected()){
            JOptionPane.showMessageDialog(null,"Seleccione solamente si es ingreso o egreso\nNo puede colocar los dos");
        }
        if(entradaCheck.isSelected() && !salidadCheck.isSelected()){
            flujo.setTipoOperacionNuevo("ingreso");
        }
        if(salidadCheck.isSelected() && !entradaCheck.isSelected()){
            flujo.setTipoOperacionNuevo("egreso");
        }
    }

}
