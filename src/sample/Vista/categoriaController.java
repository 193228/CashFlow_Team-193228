package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
<<<<<<< HEAD
import sample.Main;
=======
import sample.Datos.categoriaDAO;
import sample.Main;
import sample.Modelo.categoria;
>>>>>>> Eyssy

import java.net.URL;
import java.util.ResourceBundle;

public class categoriaController implements Initializable {

    @FXML
    private TableView<categoria> tableView;

    @FXML
    private TableColumn<categoria, String> clasificacionColumn;

    @FXML
    private TableColumn<categoria, String> categoriaColumn;

    @FXML
    private TableColumn<categoria, String> subcatColumn;

    private ObservableList<categoria> items = FXCollections.observableArrayList();
    //Separar por ahora

    @FXML
    private JFXTextField categoriaTextfield;

    @FXML
    private JFXTextField subTextfield;

    @FXML
    private JFXButton botonCategorias;

    @FXML
    private ComboBox calsificacionCombo;

    @FXML
    void botonClicked(MouseEvent event) {
        categoriaDAO dao = new categoriaDAO();
        categoria categoriaNueva = new categoria();
        if(tableView.getSelectionModel().getSelectedItem() == null) {
            //Metodo Agregar
            categoriaNueva.setNombre(categoriaTextfield.getText());
            categoriaNueva.setSubcategorias(subTextfield.getText());
            categoriaNueva.setClasificacion(calsificacionCombo.getSelectionModel().getSelectedItem().toString());
            dao.agregarCategoria(categoriaNueva);
        }
        else {
            System.out.println("Entro bro.");
            categoriaNueva.setNombre(categoriaTextfield.getText());
            categoriaNueva.setSubcategorias(subTextfield.getText());
            categoriaNueva.setClasificacion(calsificacionCombo.getSelectionModel().getSelectedItem().toString());

            categoria categoriaVieja = tableView.getSelectionModel().getSelectedItem();

            dao.actualizarCategoria(categoriaNueva, categoriaVieja);
        }
        items.clear();
        listar(items);
        tableView.setItems(items);
        clasificacionColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("clasificacion"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("nombre"));
        subcatColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("subcategorias"));
        categoriaTextfield.clear();
        subTextfield.clear();
        calsificacionCombo.getSelectionModel().clearSelection();
    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listar(items);
        tableView.setItems(items);
        clasificacionColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("clasificacion"));
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("nombre"));
        subcatColumn.setCellValueFactory(new PropertyValueFactory<categoria,String>("subcategorias"));

        ObservableList<String> listaString = FXCollections.observableArrayList("Personal", "Asociado", "Deuda", "Impuesto"); //Nota: Son Strings, por lo que le pueden agregar cualquier cosa. valores por determinados.
        calsificacionCombo.setItems(listaString);
    }

    public void listar(ObservableList<categoria> items) {
        categoriaDAO dao = new categoriaDAO();
        for (categoria categorias:dao.getListaCategorias()) {
            System.out.println(categorias);
            items.add(categorias);
        }
    }
}
