/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.Atribuicao;
import br.com.etec.service.AtribuicaoService;
import br.com.etec.view.PrincipalAtribuicaoView;
import java.beans.PropertyVetoException;
import javax.annotation.PostConstruct;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Component
public class AtribuicaoController extends AbstractInternalController<AtribuicaoService, PrincipalAtribuicaoView, Atribuicao>{

    @Autowired
    public AtribuicaoController(AtribuicaoService atribuicaoService ,PrincipalAtribuicaoView principalAtribuicaoView){
        super(atribuicaoService, principalAtribuicaoView);
    }

    @PostConstruct
    @Override
    protected final void init(){
        super.init();
    }
}
