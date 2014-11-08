package br.com.reclame.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private final String url = "jdbc:mysql://localhost:3306/reclame?user=root&password=root";

    /**
     * Obtém a conexão ao banco de dados.
     * 
     * @return conexão ao banco de dados
     */
    public Connection getConexao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
