package br.com.reclame.bo;

import br.com.reclame.dao.UsuarioDAO;
import br.com.reclame.exceptions.UsuarioInvalidoException;
import br.com.reclame.vo.UsuarioVO;

public class UsuarioBO {

    public boolean validarCadastro(UsuarioVO vo) throws UsuarioInvalidoException {
        if (vo.getLogin().equals("qualquercoisa")) {
            throw new UsuarioInvalidoException("Usuário inválido");
        } else {
            UsuarioDAO dao = new UsuarioDAO();
            return dao.inserir(vo);
        }
    }

}
