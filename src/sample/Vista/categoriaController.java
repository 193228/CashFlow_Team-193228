package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.lowagie.text.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Datos.categorio_flujo_table;
import sample.Datos.entidadCategorias;
import sample.Main;
import sample.Modelo.crudCategorias;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class categoriaController implements Initializable {

    @FXML
    private TableView<entidadCategorias> tableView;

    @FXML
    private TableColumn<entidadCategorias, String> clasificacionColumn;

    @FXML
    private TableColumn<entidadCategorias, String> categoriaColumn;

    @FXML
    private TableColumn<entidadCategorias, String> subcatColumn;

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

    private entidadCategorias entidad_Categorias = new entidadCategorias();
    private crudCategorias crud = new crudCategorias();
    categorio_flujo_table categorio = new categorio_flujo_table();

    ObservableList<entidadCategorias> listarCategorias;
    private boolean lock=false;

    @FXML
    void botonClicked(MouseEvent event) {

        if(tableView.getSelectionModel().getSelectedItems().toString().length() ==2){
            System.out.println("No selecciono nada");
            entidad_Categorias.setCategoria(categoriaTextfield.getText());
            entidad_Categorias.setClasificacion(calsificacionCombo.getSelectionModel().getSelectedItem());
            entidad_Categorias.setSubcategoria(subTextfield.getText());
            entidadCategorias addCategoria = new entidadCategorias(entidad_Categorias.getCategoria(),entidad_Categorias.getClasificacion(),entidad_Categorias.getSubcategoria());
            validarRegistro(addCategoria);
            if(!lock)
                crud.insert(addCategoria);
        }else if(tableView.getSelectionModel().getSelectedItems().toString().length() >2){
            entidad_Categorias.setCategoria(tableView.getSelectionModel().getSelectedItem().getCategoria());
            entidad_Categorias.setClasificacion(tableView.getSelectionModel().getSelectedItem().getClasificacion());
            entidad_Categorias.setSubcategoria(tableView.getSelectionModel().getSelectedItem().getSubcategoria());
            entidad_Categorias.setClasificacionNueva(calsificacionCombo.getSelectionModel().getSelectedItem());
            entidad_Categorias.setCategoriaNueva(categoriaTextfield.getText());
            entidad_Categorias.setSubcategoriaNueva(subTextfield.getText());
            if(entidad_Categorias.getCategoriaNueva().length()==0 || entidad_Categorias.getSubcategoriaNueva().length()==0 || entidad_Categorias.getClasificacionNueva().length()==0){
                JOptionPane.showMessageDialog(null,"No se pueden dejar campos vacios\nIntente nuevamente");
            }else{
                entidadCategorias updateCategoria = new entidadCategorias(entidad_Categorias.getCategoriaNueva(),entidad_Categorias.getClasificacionNueva(),entidad_Categorias.getSubcategoriaNueva(),entidad_Categorias.getCategoria(),entidad_Categorias.getClasificacion(),entidad_Categorias.getSubcategoria());
                crud.update(updateCategoria);
            }
        }
        llenarTabla();
    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        llenarTabla();
        calsificacionCombo.getItems().add("GAO");
        calsificacionCombo.getItems().add("Ingreso");
        calsificacionCombo.getItems().add("Costo-Venta");
    }

    public void llenarTabla(){
        listarCategorias = FXCollections.observableList(crud.getAllCategorias());
        tableView.setItems(listarCategorias);
        clasificacionColumn.setCellValueFactory(new PropertyValueFactory<entidadCategorias,String>("clasificacion"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<entidadCategorias,String>("categoria"));
        subcatColumn.setCellValueFactory(new PropertyValueFactory<entidadCategorias,String>("subcategoria"));
    }

    public void validarRegistro(entidadCategorias categorias){
        System.out.println("VEAMOS PUES ");
        for(int i=0; i<tableView.getItems().size(); i++){
            if(categorias.getCategoria().equals(tableView.getItems().get(i).getCategoria()) &&
            categorias.getClasificacion().equals(tableView.getItems().get(i).getClasificacion()) &&
            categorias.getSubcategoria().equals(tableView.getItems().get(i).getSubcategoria())){
                JOptionPane.showMessageDialog(null,"Campo ya existe");
                lock = true;
                break;
            }else{
                lock = false;
            }
        }
    }

}
