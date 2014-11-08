package br.com.reclame.bo;

import br.com.reclame.dao.ReclamacaoDAO;
import br.com.reclame.exceptions.ReclamacaoInvalidaException;
import br.com.reclame.vo.ReclamaVO;

public class ReclamacaoBO {

    public boolean validarCadastro(ReclamaVO vo) throws ReclamacaoInvalidaException {
        if (vo.getAssunto().equals("Emanuela")) {
            throw new ReclamacaoInvalidaException("Reclamação inválida");
        } else {
            ReclamacaoDAO dao = new ReclamacaoDAO();
            return dao.inserir(vo);
        }
    }

}
