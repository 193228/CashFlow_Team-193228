package sample.Modelo;
import sample.Adaptador.adaptadorSql;
import sample.Datos.entidadBancos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class crudBancos {

    private Connection connection = null;
    private final int ACCEPT = 1;

    public crudBancos() {
        adaptadorSql conector = new adaptadorSql();
        connection = conector.getConnection();
    }



    public boolean insert(entidadBancos bancos) {
        boolean resultado = false;
        if (connection != null) {
            String sql = "insert into bancos (numeroSemana, monto, descripcion) values(?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,bancos.getNumeroSemana());
                statement.setFloat(2,bancos.getMonto());
                statement.setString(3,bancos.getDescripcion());
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
