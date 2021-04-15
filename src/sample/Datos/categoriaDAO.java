package sample.Datos;

import sample.Adaptador.adaptadorSql;
import sample.Modelo.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoriaDAO {
    private Connection connection = null;
    private final int ACCEPT = 1;

    public categoriaDAO() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }

    public List<categoria> getListaCategorias() {
        List<categoria> categoriaList = new ArrayList<>();
        if (connection != null) {
            String sql = "select * from Categorias";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    categoria categorias = new categoria(results.getString(2), results.getString(4), results.getString(3));
                    categoriaList.add(categorias);
                    System.out.println(results.getString(2));
                    System.out.println(results.getString(4));
                    System.out.println(results.getString(3));
                }
            }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Error de Conexion");
        }
        return categoriaList;
    }

    public void agregarCategoria(categoria nuevaCategoria) {
        if(connection != null) {
            String sql = "INSERT INTO Categorias (Categoria,Clasificacion,subCategoria) VALUES (?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nuevaCategoria.getNombre());
                statement.setString(2, nuevaCategoria.getClasificacion());
                statement.setString(3, nuevaCategoria.getSubcategorias());
                statement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarCategoria(categoria nuevaCategoria, categoria viejaCategoria) {
        if(connection != null) {
            String sql = "UPDATE categorias SET Categoria = ?, Clasificacion = ?, subCategoria = ? WHERE Categoria = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nuevaCategoria.getNombre());
                statement.setString(2, nuevaCategoria.getClasificacion());
                statement.setString(3, nuevaCategoria.getSubcategorias());
                statement.setString(4, viejaCategoria.getNombre());
                statement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
