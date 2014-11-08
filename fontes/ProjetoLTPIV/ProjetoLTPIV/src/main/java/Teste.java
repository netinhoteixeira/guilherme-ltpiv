import java.sql.SQLException;

import br.com.reclame.conexao.Conexao;

public class Teste {

    public static void main(String[] args) throws SQLException {

        Conexao con = new Conexao();

        if (con.getConexao().isValid(0)) {
            System.out.println("esta conectado");
        } else {
            System.out.println("a conexao foi perdida ou nao foi iniciada/foi encerrada");
        }
    }

}
