/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Atribuicao;
import br.com.etec.repository.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class AtribuicaoService extends AbstractService<Atribuicao> {

    @Deprecated
    public AtribuicaoService(){
        this(null);
    }

    @Autowired
    public AtribuicaoService(AtribuicaoRepository atribuicaoRepository){
        super(atribuicaoRepository);
    }

}
