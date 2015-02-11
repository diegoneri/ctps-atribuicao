/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.model.DefaultModel;
import br.com.etec.service.AbstractService;
import br.com.etec.util.Utils;
import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

/**
 * Controller abstrato direcionado a gerenciar componentes JInternalFrame que
 * sejam instanciados dentro do MainController.
 *
 * Possui uma view interna, bastando criar outras views nos filhos
 * caso necessário
 *
 * @see br.com.etec.controller.AbstractController
 *
 * @author Diego Neri - #diegoneri
 */
@Controller
public abstract class AbstractInternalController<S extends AbstractService
                                               , F extends JInternalFrame
                                               , M extends DefaultModel> extends AbstractController {

    //Liberar o main controller para o pai, para implementar a janela de mensagens corretamente.
    private F view;
    private MainController main;
    private S service;

    @Deprecated
    public AbstractInternalController(){}

    @Deprecated
    public AbstractInternalController(MainController parent){
        super(parent);
    }

    public AbstractInternalController(S service, F view){
        this.service = service;
        this.view = view;
    }

    protected F getView(){
        return view;
    }

    protected final S getService(){
        return service;
    }

    protected void init(){
        addKeyAndContainerListenerRecursively(view);
        initGraphicalOptions();
    }

    public final void show(MainController main) {
        this.main = main;
        this.main.addViewToPane(getView());
        getView().setVisible(true);
        try {
            getView().setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AtribuicaoController.class.getName()).log(Level.WARN, "Não foi possível maximizar a tela" , ex);
        }
        getView().requestFocus();
    }

    private void initGraphicalOptions() {
        getView().setFrameIcon(Utils.getDefaultImageIcon());
    }

    @Override
    protected void fecharJanela() {
        view.setVisible(false);
        main.returnFocusToMain();
    }

    @Override
    protected void showErrorMessage(String message, String title){
        JOptionPane.showMessageDialog(view , message , title , JOptionPane.ERROR_MESSAGE);
    }
}
