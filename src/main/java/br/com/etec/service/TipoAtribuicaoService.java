/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.TipoAtribuicao;
import br.com.etec.repository.TipoAtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class TipoAtribuicaoService extends AbstractService<TipoAtribuicao> {

    @Deprecated
    public TipoAtribuicaoService(){
        this(null);
    }

    @Autowired
    public TipoAtribuicaoService(TipoAtribuicaoRepository tipoAtribuicaoRepository){
        super(tipoAtribuicaoRepository);
    }

}
