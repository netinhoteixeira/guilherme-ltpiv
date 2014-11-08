package br.com.reclame.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.reclame.bo.UsuarioBO;
import br.com.reclame.vo.UsuarioVO;
import br.com.reclame.exceptions.UsuarioInvalidoException;

public class UsuarioInserirServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UsuarioVO vo = new UsuarioVO();
        vo.setLogin(req.getParameter("login"));
        vo.setSenha(req.getParameter("senha"));
        vo.setEmail(req.getParameter("email"));

        UsuarioBO bo = new UsuarioBO();
        try {
            if (bo.validarCadastro(vo)) {
                resp.sendRedirect("UsuarioListar.jsp");
            } else {
                resp.sendRedirect("UsuarioInserir.jsp");
            }
        } catch (UsuarioInvalidoException e) {
            resp.sendRedirect("UsuarioInserir.jsp");
        }
    }

}
