package br.com.reclame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.reclame.conexao.Conexao;
import br.com.reclame.vo.ReclamaVO;

public class ReclamacaoDAO {

    public boolean inserir(ReclamaVO vo) {
        Connection con = new Conexao().getConexao();
        String sql = "insert into teste (nome) values (?)";//Colunas da tabela
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getAssunto());
            ps.setString(2, vo.getTexto());
//			ps.setInt(2,vo.getIdade());
            return ps.execute();
        } catch (SQLException e) {
            return false;
        }
    }

}
