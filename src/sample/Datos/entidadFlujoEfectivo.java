package sample.Datos;

import sample.Adaptador.adaptadorSql;

import javax.swing.*;
import java.sql.*;

public class entidadFlujoEfectivo {

    private int idCategoria;
    private String fecha, descripcion, descripcionNueva;
    private float Monto,montoNuevo;
    private String tipoOperacion,tipoOperacionNuevo;

    private Connection connection = null;

    public entidadFlujoEfectivo() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }

    public entidadFlujoEfectivo(int idCategoria, String fecha, String descripcion, float monto, String tipoOperacion) {
        this.idCategoria = idCategoria;
        this.fecha = fecha;
        this.descripcion = descripcion;
        Monto = monto;
        this.tipoOperacion = tipoOperacion;
    }

    public entidadFlujoEfectivo(int idCategoria, String fecha, String descripcionNueva, float montoNuevo, String tipoOperacionNueva, String descripcion, float monto, String tipoOperacion) {
        this.idCategoria = idCategoria;
        this.fecha = fecha;
        descripcion = descripcion;
        this.tipoOperacion = tipoOperacion;
        descripcionNueva = descripcionNueva;
        this.tipoOperacion = tipoOperacionNueva;
        Monto = monto;
        montoNuevo = montoNuevo;
    }

    public entidadFlujoEfectivo(int idCategoria, String fecha, String descripcion, String descripcionNueva, float monto, String tipoOperacion) {
    }


    public String getDescripcionNueva() {
        return descripcionNueva;
    }

    public void setDescripcionNueva(String descripcionNueva) {
        this.descripcionNueva = descripcionNueva;
    }

    public float getMontoNuevo() {
        return montoNuevo;
    }

    public void setMontoNuevo(float montoNuevo) {
        this.montoNuevo = montoNuevo;
    }

    public String getTipoOperacionNuevo() {
        return tipoOperacionNuevo;
    }

    public void setTipoOperacionNuevo(String tipoOperacionNuevo) {
        this.tipoOperacionNuevo = tipoOperacionNuevo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public void obtenerFecha() {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT CONVERT(DATE, GETDATE())");
            ResultSet rs = st.executeQuery();
            while (rs.next()){ setFecha(rs.getString(1)); }
        }catch (Exception e){}
    }

}
