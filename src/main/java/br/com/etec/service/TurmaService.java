/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Turma;
import br.com.etec.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class TurmaService extends AbstractService<Turma> {

    @Deprecated
    public TurmaService(){
        this(null);
    }

    @Autowired
    public TurmaService(TurmaRepository turmaRepository){
        super(turmaRepository);
    }

}
