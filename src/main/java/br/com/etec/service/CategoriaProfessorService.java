/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.service;

import br.com.etec.model.CategoriaProfessor;
import br.com.etec.repository.CategoriaProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Service
@Repository
public class CategoriaProfessorService extends AbstractService<CategoriaProfessor> {

    @Deprecated
    public CategoriaProfessorService(){
        this(null);
    }

    @Autowired
    public CategoriaProfessorService(CategoriaProfessorRepository categoriaProfessorRepository){
        super(categoriaProfessorRepository);
    }

}
