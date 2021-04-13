package sample.Crud;

import sample.Adaptador.adaptadorSql;
import sample.Datos.entidadCuentas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class crudCuentas {

    private Connection connection = null;
    private final int ACCEPT = 1;

    public crudCuentas() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }



    public boolean insert(entidadCuentas cuentas) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into cuentas (numeroSemana, razonSocial, Monto, tipoOperacion) values(?,?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
               statement.setInt(1,cuentas.getNumeroSemana());
               statement.setString(2,cuentas.getRazonSocial());
               statement.setFloat(3,cuentas.getMonto());
               statement.setString(4,cuentas.getTipoOperacion());
                if (statement.executeUpdate() == ACCEPT)
                    resultado = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resultado;
    }

}
