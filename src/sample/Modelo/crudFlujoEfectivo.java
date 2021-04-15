package sample.Modelo;

import sample.Adaptador.adaptadorSql;
import sample.Datos.categorio_flujo_table;
import sample.Datos.entidadCategorias;
import sample.Datos.entidadFlujoEfectivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class crudFlujoEfectivo {

    private Connection connection = null;
    private final int ACCEPT = 1;

    public crudFlujoEfectivo() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }

    public boolean insert(entidadFlujoEfectivo flujoEfectivo){
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into flujoEfectivo (idCategoria, fecha, descripcion, Monto, tipoOperacion) values(?,?,?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,flujoEfectivo.getIdCategoria());
                statement.setString(2,flujoEfectivo.getFecha());
                statement.setString(3,flujoEfectivo.getDescripcion());
                statement.setFloat(4,flujoEfectivo.getMonto());
                statement.setString(5,flujoEfectivo.getTipoOperacion());
                if (statement.executeUpdate() == ACCEPT)
                    resultado = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }



    public boolean update(entidadFlujoEfectivo flujo){
        boolean resultado = false;
        if (connection != null) {
            String sql = "UPDATE flujoEfectivo SET idCategoria=?, fecha=?, descripcion = ?, Monto = ?, tipoOperacion = ? " +
                    "WHERE idCategoria = ?";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,flujo.getIdCategoria());
                statement.setString(2,flujo.getFecha());
                statement.setString(3,flujo.getDescripcion());
                statement.setFloat(4,flujo.getMonto());
                statement.setString(5,flujo.getTipoOperacion());
                statement.setInt(6,flujo.getIdCategoria());
                if (statement.executeUpdate() == ACCEPT){
                    System.out.println("as");
                    resultado = true;
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }

    public ArrayList<categorio_flujo_table> getAllFlujo() {
        ArrayList<categorio_flujo_table> flujo = new ArrayList<>();

        if (connection != null) {
            String sql = "select * from flujoefectivo inner join categorias on flujoefectivo.idCategoria = categorias.idCategorias";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet results = statement.executeQuery();
                while (results.next()) {
                    String fecha = results.getString(3);
                    String descripcion = results.getString(4);
                    String categoria = results.getString(8);
                    String subCategoria = results.getString(10);
                    categorio_flujo_table list = new categorio_flujo_table(fecha,descripcion,categoria,subCategoria);
                    flujo.add(list);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flujo;
    }

}
