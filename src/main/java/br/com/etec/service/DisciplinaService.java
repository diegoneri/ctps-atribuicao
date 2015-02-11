/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Disciplina;
import br.com.etec.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class DisciplinaService extends AbstractService<Disciplina> {

    @Deprecated
    public DisciplinaService(){
        this(null);
    }

    @Autowired
    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        super(disciplinaRepository);
    }

}
