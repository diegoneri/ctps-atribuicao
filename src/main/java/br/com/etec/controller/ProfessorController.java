/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.Professor;
import br.com.etec.service.ProfessorService;
import br.com.etec.view.ProfessorView;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Component
public class ProfessorController extends AbstractInternalController<ProfessorService, ProfessorView, Professor> {

    @Autowired
    public ProfessorController(ProfessorService professorService, ProfessorView professorView){
        super(professorService, professorView);
    }

    @PostConstruct
    @Override
    protected final void init(){
        super.init();
    }
}
