package br.com.reclame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.reclame.vo.UsuarioVO;
import br.com.reclame.conexao.Conexao;
import java.util.List;

public class UsuarioDAO {

    public boolean inserir(UsuarioVO vo) {

        Connection con = new Conexao().getConexao();
        String sql = "INSERT INTO Usuario (Login, Senha, Email) VALUES (?, ?, ?)";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getLogin());
            ps.setString(2, vo.getSenha());
            ps.setString(3, vo.getEmail());

            return ps.execute();
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean delete(UsuarioVO vo) {
        Connection con = new Conexao().getConexao();

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Usuario WHERE (idUsuario = ?)");
            ps.setInt(1, vo.getIdUsuario());
            ps.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean update(UsuarioVO vo) {

        Connection con = new Conexao().getConexao();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Usuario SET Login = ?, Senha = ?, Email = ? WHERE (idUsuario = ?)");
            ps.setString(1, vo.getLogin());
            ps.setString(2, vo.getSenha());
            ps.setString(3, vo.getEmail());
            ps.execute();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<UsuarioVO> consulta() {

        Connection con = new Conexao().getConexao();
        java.sql.Statement stmt;
        ResultSet rs;
        UsuarioVO usurio;
        List<UsuarioVO> usuarios = new ArrayList<>();
        String sql = "SELECT idUsuario, Login, Senha, Email FROM Usuario";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                usurio = new UsuarioVO();
                usurio.setIdUsuario(rs.getInt("IdUsuario"));
                usurio.setLogin(rs.getString("Login"));
                usurio.setSenha(rs.getString("Senha"));
                usurio.setEmail(rs.getString("Email"));

                usuarios.add(usurio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

}
