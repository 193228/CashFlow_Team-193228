package sample.Adaptador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class adaptadorSql {
    public Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:sqlserver://localhost:1433;databaseName=cashflowTeam";
        String user = "sa";
        String password = "nanguelu01";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("esta conectado a sql desde "+connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}