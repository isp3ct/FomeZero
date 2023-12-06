//CRIADOR: JOÃO VICTOR DOS SANTOS COSTA.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    static final String URL = "jdbc:mysql://127.0.0.1:3306/FomeZero";
    static final String USUARIO = "root";
    static final String SENHA = "root";

    public Connection conectar() {
        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conexao;
    }
}