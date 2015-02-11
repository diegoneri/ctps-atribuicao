/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.Professor;
import br.com.etec.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class ProfessorService extends AbstractService<Professor> {

    @Deprecated
    public ProfessorService(){
        this(null);
    }

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository){
        super(professorRepository);
    }

}
