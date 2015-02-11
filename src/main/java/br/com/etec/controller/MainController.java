/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.controller;

import br.com.etec.view.MainView;
import br.com.etec.view.action.AbstractAction;
import javax.annotation.PostConstruct;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego Neri - #diegoneri
 */
@Component
public class MainController extends AbstractController {

    private static final String DESEJA_ENCERRAR_O_SISTEMA = "Deseja encerrar o sistema?";
    private static final String SAÍDA_DE_TELA = "Encerrando...";
    @Autowired
    private MainView view;
    @Autowired
    private AtribuicaoController atribuicaoController;
    @Autowired
    private ProfessorController professorController;
    @Autowired
    private CategoriaProfessorController categoriaProfessorController;
    @Autowired
    private TipoContratoController tipoContratoController;

    public MainController() {
    }

    @PostConstruct
    private void init() {
        view.addWindowListener(this);
        addKeyAndContainerListenerRecursively(view);
        registerAction(view.getMenuItemAtribuicaoAulas() , new AbstractAction() {
            @Override
            public void action() {
                initAtribuicaoAulas();
            }
        });
        registerAction(view.getMenuItemProfessor() , new AbstractAction() {
            @Override
            protected void action() {
                initProfessor();
            }
        });
        registerAction(view.getMenuItemCategoriaFuncional() , new AbstractAction() {
            @Override
            protected void action() {
                initCategoriaProfessor();
            }
        });
        registerAction(view.getMenuItemTipoContrato() , new AbstractAction() {
            @Override
            protected void action() {
                initTipoContrato();
            }
        });
    }

    private void initAtribuicaoAulas() {
        atribuicaoController.show(this);
    }

    private void initProfessor() {
        professorController.show(this);
    }

    private void initCategoriaProfessor() {
        categoriaProfessorController.show(this);
    }

    private void initTipoContrato() {
        tipoContratoController.show(this);
    }

    protected void addViewToPane(JInternalFrame frame) {
        if (view.getMainPane().getIndexOf(frame) == -1) {
            this.view.getMainPane().add(frame);
        }
    }

    public void show(AbstractController previousController) {
        previousController.cleanUp();
        view.setVisible(true);
        view.setResizable(false);
    }

    @Override
    protected void fecharJanela() {
        if (view.hasFocus()) {
            int resp =
                    JOptionPane.showConfirmDialog(view , DESEJA_ENCERRAR_O_SISTEMA , SAÍDA_DE_TELA , JOptionPane.OK_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE);
            if (resp == JOptionPane.OK_OPTION) {
                System.exit(JOptionPane.OK_OPTION);
            }
        }
    }

    protected void returnFocusToMain() {
        this.view.requestFocus();
    }
    
    @Override
    protected void showErrorMessage(String message, String title){
        JOptionPane.showMessageDialog(view , message , title , JOptionPane.ERROR_MESSAGE);
    }
}
