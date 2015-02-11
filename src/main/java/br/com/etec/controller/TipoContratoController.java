/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.Professor;
import br.com.etec.model.TipoContrato;
import br.com.etec.service.TipoContratoService;
import br.com.etec.view.TipoContratoView;
import javax.annotation.PostConstruct;
import javax.swing.JComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author dfelix3
 */
@Controller
public class TipoContratoController extends PagingController<TipoContratoService, TipoContratoView, TipoContrato> {

    @Autowired
    public TipoContratoController(TipoContratoService service, TipoContratoView view){
        super(service , view);
    }

    @PostConstruct
    @Override
    protected final void init(){
        super.init();
    }

    @Override
    protected void clearFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void enableFields(Boolean flag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void setDefaultFocusedComponent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected JComponent getIdentityComponent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected TipoContrato getNewModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}