package sample.Vista;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import sample.Modelo.crudBancos;
import sample.Modelo.crudCuentas;
import sample.Datos.entidadBancos;
import sample.Datos.entidadCuentas;
import sample.Main;
import sample.Modelo.validacionNumerica;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class registroController implements Initializable {

    @FXML
    private JFXTextField nsemanaCobrarTexfield;

    @FXML
    private JFXTextField rsocialCobrarTexfield;

    @FXML
    private JFXTextField montoCobrarTexfield;

    @FXML
    private JFXButton cobrarBoton;

    @FXML
    private JFXTextField nsemanaPagarTexfield;

    @FXML
    private JFXTextField rsocialPagarTexfield;

    @FXML
    private JFXTextField montoPagarTexfield;

    @FXML
    private JFXButton pagarBoton;

    @FXML
    private JFXTextField nsemanaBancoTexfield;

    @FXML
    private JFXTextField descripcionBancoTexfiled;

    @FXML
    private JFXTextField montoBancoTexfield;

    @FXML
    private JFXButton bancosBoton;

    @FXML
    private JFXButton regresarBoton;

    private validacionNumerica validacion = new validacionNumerica();
    private entidadCuentas entidad_cuenta = new entidadCuentas();
    private entidadBancos entidad_banco = new entidadBancos();
    private crudCuentas crud_cuenta = new crudCuentas();
    private crudBancos crud_banco = new crudBancos();

    @FXML
    void bancosBoton(MouseEvent event) {

        if(!validacion.validarDatosEnteros(nsemanaBancoTexfield.getText()))
            JOptionPane.showMessageDialog(null,"No se reconocio el numero de semana\nIntenta nuevamente");

        if(!validacion.validarDatosDecimales(montoBancoTexfield.getText()))
            JOptionPane.showMessageDialog(null,"Monto no reconocido\nIntenta nuevamente");

        entidad_banco.setNumeroSemana(Integer.parseInt(nsemanaBancoTexfield.getText()));

        if(entidad_banco.getNumeroSemana()<1 || entidad_banco.getNumeroSemana()>5){
            JOptionPane.showMessageDialog(null,"Semana ingresada incorrectamente\nIngrese un dato entre 1 a 5");
        }else{
            entidad_banco.setNumeroSemana(Integer.parseInt(nsemanaBancoTexfield.getText()));
            entidad_banco.setMonto(Float.parseFloat(montoBancoTexfield.getText()));
            entidad_banco.setDescripcion(descripcionBancoTexfiled.getText());
            entidadBancos entidad = new entidadBancos(entidad_banco.getNumeroSemana(),entidad_banco.getMonto(),entidad_banco.getDescripcion());
            crud_banco.insert(entidad);
        }

    }

    @FXML
    void cobrarBoton(MouseEvent event) {

        if(!validacion.validarDatosEnteros(nsemanaCobrarTexfield.getText()))
            JOptionPane.showMessageDialog(null,"No se reconocio el numero de semana\nIntenta nuevamente");

        if(!validacion.validarDatosDecimales(montoCobrarTexfield.getText()))
            JOptionPane.showMessageDialog(null,"Monto no reconocido\nIntenta nuevamente");

        entidad_cuenta.setNumeroSemana(Integer.parseInt(nsemanaCobrarTexfield.getText()));

        if(entidad_cuenta.getNumeroSemana()<1 || entidad_cuenta.getNumeroSemana()>5){
            JOptionPane.showMessageDialog(null,"Semana ingresada incorrectamente\nIngrese un dato entre 1 a 5");
        }else{
            entidad_cuenta.setNumeroSemana(Integer.parseInt(nsemanaCobrarTexfield.getText()));
            entidad_cuenta.setMonto(Float.parseFloat(montoCobrarTexfield.getText()));
            entidad_cuenta.setRazonSocial(rsocialCobrarTexfield.getText());
            entidad_cuenta.setTipoOperacion("por cobrar");
            entidadCuentas cuentas = new entidadCuentas(entidad_cuenta.getNumeroSemana(),entidad_cuenta.getRazonSocial(),entidad_cuenta.getMonto(),entidad_cuenta.getTipoOperacion());
            crud_cuenta.insert(cuentas);
        }

    }

    @FXML
    void pagarBoton(MouseEvent event) {
        if(!validacion.validarDatosEnteros(nsemanaPagarTexfield.getText()))
            JOptionPane.showMessageDialog(null,"No se reconocio el numero de semana\nIntenta nuevamente");

        if(!validacion.validarDatosDecimales(montoPagarTexfield.getText()))
            JOptionPane.showMessageDialog(null,"Monto no reconocido\nIntenta nuevamente");

        entidad_cuenta.setNumeroSemana(Integer.parseInt(nsemanaPagarTexfield.getText()));

        if(entidad_cuenta.getNumeroSemana()<1 || entidad_cuenta.getNumeroSemana()>5){
            JOptionPane.showMessageDialog(null,"Semana ingresada incorrectamente\nIngrese un dato entre 1 a 5");
        }else{
            entidad_cuenta.setNumeroSemana(Integer.parseInt(nsemanaPagarTexfield.getText()));
            entidad_cuenta.setMonto(Float.parseFloat(montoPagarTexfield.getText()));
            entidad_cuenta.setRazonSocial(rsocialPagarTexfield.getText());
            entidad_cuenta.setTipoOperacion("por pagar");
            entidadCuentas cuentas = new entidadCuentas(entidad_cuenta.getNumeroSemana(),entidad_cuenta.getRazonSocial(),entidad_cuenta.getMonto(),entidad_cuenta.getTipoOperacion());
            crud_cuenta.insert(cuentas);
        }

    }
    @FXML
    void regresarClicked(MouseEvent event) {
        Main.setFXML("Menu","Finanzas");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
