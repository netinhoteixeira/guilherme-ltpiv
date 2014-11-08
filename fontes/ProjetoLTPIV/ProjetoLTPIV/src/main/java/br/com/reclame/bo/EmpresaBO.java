package br.com.reclame.bo;

import br.com.reclame.dao.EmpresaDAO;
import br.com.reclame.exceptions.EmpresaInvalidaException;
import br.com.reclame.vo.EmpresaVO;

public class EmpresaBO {

    public boolean validarCadastro(EmpresaVO vo) throws EmpresaInvalidaException {
        if (vo.getNome().equals("qualquercoisa")) {
            throw new EmpresaInvalidaException("Empresa inválida");
        } else {
            EmpresaDAO dao = new EmpresaDAO();
            return dao.inserir(vo);
        }
    }

}
