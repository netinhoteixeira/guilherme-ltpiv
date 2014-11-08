package br.com.reclame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.reclame.vo.EmpresaVO;
import br.com.reclame.conexao.Conexao;
import java.util.List;

public class EmpresaDAO {

    /**
     * Insere uma empresa.
     *
     * @param empresa
     * @return
     */
    public boolean inserir(EmpresaVO empresa) {

        Connection con = new Conexao().getConexao();
        String sql = "INSERT INTO Empresa (Nome, Tipo) values (?, ?)";
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empresa.getNome());
            //ps.setString(2, vo.getSenha());
            ps.setString(2, empresa.getTipo());

            return ps.execute();
        } catch (SQLException e) {
            return false;
        }

    }

    /**
     *
     * @param empresa
     * @return
     */
    public boolean delete(EmpresaVO empresa) {

        Connection con = new Conexao().getConexao();

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Empresa WHERE (idEmpresa = ?)");
            ps.setInt(1, empresa.getIdEmpresa());
            ps.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public boolean update(EmpresaVO vo) {
        Connection con = new Conexao().getConexao();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Empresa SET Nome = ?, Tipo = ? WHERE (idEmpresa = ?)");
            ps.setString(1, vo.getNome());
            ps.setString(2, vo.getTipo());
            ps.execute();

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Lista das empresas.
     *
     * @return empresas
     */
    public java.util.List<EmpresaVO> consulta() {

        Connection con = new Conexao().getConexao();
        java.sql.Statement stmt;
        ResultSet rs;
        EmpresaVO emp;
        List<EmpresaVO> empresas = new ArrayList<>();
        String sql = "SELECT idEmpresa, Nome, Tipo FROM Empresa";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                emp = new EmpresaVO();
                emp.setIdEmpresa(rs.getInt("IdEmpresa"));
                emp.setNome(rs.getString("Nome"));
                emp.setTipo(rs.getString("Tipo"));

                empresas.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empresas;
    }

}
