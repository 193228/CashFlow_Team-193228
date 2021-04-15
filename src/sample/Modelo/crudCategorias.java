package sample.Modelo;

import sample.Adaptador.adaptadorSql;
import sample.Datos.entidadCategorias;
import sample.Datos.entidadCuentas;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class crudCategorias {

    private Connection connection = null;
    private final int ACCEPT = 1;

    public crudCategorias() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }



    public boolean insert(entidadCategorias categorias){
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into categorias (categoria,clasificacion,subcategoria) values(?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,categorias.getCategoria());
                statement.setString(2,categorias.getClasificacion());
                statement.setString(3,categorias.getSubcategoria());
                if (statement.executeUpdate() == ACCEPT)
                    resultado = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public boolean update(entidadCategorias categorias) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "UPDATE categorias SET Categoria = ?, Clasificacion = ?, subCategoria = ? WHERE Categoria = ? AND clasificacion = ? AND subcategoria = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, categorias.getCategoriaNueva());
                statement.setString(2, categorias.getClasificacionNueva());
                statement.setString(3, categorias.getSubcategoriaNueva());
                statement.setString(4, categorias.getCategoria());
                statement.setString(5,categorias.getClasificacion());
                statement.setString(6,categorias.getSubcategoria());
                if (statement.executeUpdate() == ACCEPT){
                    resultado = true;
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public ArrayList<entidadCategorias> getAllCategorias() {
        ArrayList<entidadCategorias> categorias = new ArrayList<>();

        if (connection != null) {
            String sql = "select * from categorias";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    String categoria = results.getString(2);
                    String clasificacion = results.getString(3);
                    String subcategoria = results.getString(4);
                    entidadCategorias list = new entidadCategorias(categoria,clasificacion,subcategoria);
                    categorias.add(list);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return categorias;
    }

}
