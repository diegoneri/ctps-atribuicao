/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.CategoriaProfessor;
import br.com.etec.service.CategoriaProfessorService;
import br.com.etec.util.Operacao;
import br.com.etec.view.CategoriaProfessorView;
import javax.annotation.PostConstruct;
import javax.swing.JComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Controller
public class CategoriaProfessorController extends PagingController<CategoriaProfessorService , CategoriaProfessorView , CategoriaProfessor> {

    @Autowired
    public CategoriaProfessorController(CategoriaProfessorService categoriaProfessorService , CategoriaProfessorView categoriaProfessorView) {
        super(categoriaProfessorService , categoriaProfessorView);
    }

    @PostConstruct
    @Override
    protected final void init() {
        super.init();
    }

    @Override
    protected final void clearFields() {
        this.getView().getTxtId().setText("");
        this.getView().getTxtNome().setText("");
    }

    @Override
    protected final void enableFields(Boolean flag) {
        this.getView().getTxtId().setEnabled(flag && getOperacao() == Operacao.INCLUIR);
        this.getView().getTxtNome().setEnabled(flag);
    }

    @Override
    protected final JComponent getIdentityComponent() {
        return this.getView().getTxtId();
    }

    @Override
    protected CategoriaProfessor getNewModel() {
        return new CategoriaProfessor();
    }

    @Override
    protected void setDefaultFocusedComponent() {
        if (getOperacao() == Operacao.ALTERAR) {
            this.getView().getTxtNome().requestFocus();
        } else {
            this.getView().getTxtId().requestFocus();
        }
    }
}
